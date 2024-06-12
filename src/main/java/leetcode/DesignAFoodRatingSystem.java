package leetcode;


import java.util.*;

/*
    https://leetcode.com/problems/design-a-food-rating-system/
 */
public class DesignAFoodRatingSystem {

    class Food {
        String name;
        int rating;
        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }

    private Map<String, TreeSet<Food>> cuisineMapping;
    private Map<String, Integer> foodRatings;
    private Map<String, String> foodCuisineMapping;
    public DesignAFoodRatingSystem(String[] foods, String[] cuisines, int[] ratings) {
        cuisineMapping = new HashMap<>();
        foodRatings = new HashMap<>();
        foodCuisineMapping = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            foodRatings.put(foods[i], ratings[i]);
            foodCuisineMapping.put(foods[i], cuisines[i]);
            cuisineMapping
                .computeIfAbsent(cuisines[i], k -> new TreeSet<>((food1, food2) -> {
                    Integer r1 = food1.rating;
                    Integer r2 = food2.rating;
                    if (!r1.equals(r2)) return r2.compareTo(r1);
                    return food1.name.compareTo(food2.name);
                }))
                .add(new Food(foods[i], ratings[i]));
        }

    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisineMapping.get(food);
        TreeSet<Food> foods = cuisineMapping.get(cuisine);
        foods.remove(new Food(food, foodRatings.get(food)));
        foods.add(new Food(food, newRating));
        foodRatings.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        if (!cuisineMapping.containsKey(cuisine)) return null;
        Food food = cuisineMapping.get(cuisine).first();
        return food.name;
    }

    public static void main(String[] args) {
        DesignAFoodRatingSystem system = new DesignAFoodRatingSystem(
            new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
            new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
            new int[]{9, 12, 8, 15, 14, 7}
        );
        System.out.println(system.highestRated("korean"));
        System.out.println(system.highestRated("japanese"));
        system.changeRating("sushi", 16);
        System.out.println(system.highestRated("japanese"));
        system.changeRating("ramen", 16);
        System.out.println(system.highestRated("japanese"));
    }
}
