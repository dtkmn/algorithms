    package concurrency;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

    public class ThreadTest
{


    public static void main(String[] args) {
        int numAccounts = 10;
        var bank = new Bank(numAccounts, 10000);
        for (int i = 0; i < numAccounts; i++) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = 100 * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {

                } finally {

                }
            };
            var t = new Thread(r);
            t.setName("Runnable... " + fromAccount);
            t.start();
        }

        var f = CompletableFuture.supplyAsync(() -> {
            return "DONE";
        });
        f.whenComplete((s, t) -> {
            if (t == null) {
                // Process the result s
                System.out.println(s);
            } else {
                // Process the Throwable t
                System.err.println(t.getMessage());
            }
        });


    }

}


class Bank {

    private final Lock bankLock = new ReentrantLock();
    private final Condition sufficientFund;

    private final Object myLock = new Object();

    private final double[] accounts;
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        sufficientFund = bankLock.newCondition();
    }

    /**
     * Transfer money from one account to another
     * @param from
     * @param to
     * @param amount
     * @throws InterruptedException
     */
    void transfer(int from, int to, double amount) throws InterruptedException {
        bankLock.lock();
        try {
            System.out.println(Thread.currentThread());
            while (accounts[from] < amount) {
                // Normally we may throw custom exception to notify caller
                // If we want to wait...
                sufficientFund.await();
            }
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            System.out.println();
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            sufficientFund.signalAll();
        } finally {
            bankLock.unlock();
        }
    }

    double getTotalBalance() {
        bankLock.lock();
        try {
            double sum = 0.0;
            for (double balance : accounts) {
                sum += balance;
            }
            return sum;
        } finally {
            bankLock.unlock();
        }
    }

    synchronized void transfer2(int from, int to, double amount) throws InterruptedException {
        while (accounts[from] < amount) {
            wait();
        }
        accounts[from] -= amount;
        accounts[to] += amount;
        notifyAll();
    }

    synchronized double getTotalBalance2() {
        double sum = 0.0;
        for (double balance: accounts) {
            sum += balance;
        }
        return sum;
    }

    int size() {
        return accounts.length;
    }

}