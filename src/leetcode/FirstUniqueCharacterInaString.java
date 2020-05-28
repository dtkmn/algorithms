package leetcode;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 */
public class FirstUniqueCharacterInaString {

    // 4ms
    // Time Complexity: O(N) i.e length of s
    // Space Complexity: O(26) english lowercase letters
    public static int firstUniqChar(String s) {
        char[] str = s.toCharArray();
        // Store the count on each characters
        int[] count = new int[26];
        // Loop through and count
        for (char c: str) {
            count[c - 'a']++;
        }
        // Loop through again and find first with value 1
        for (int i = 0; i < str.length; i++) {
            if (count[str[i] - 'a'] == 1) return i;
        }
        return -1;
    }

    // 8ms
    public static int firstUniqChar_with2array(String s) {

        // Space Complexity: O(26)
        // count character appearances with the string
        int[] count = new int[26];
        // saving min index for each character within the string, default to -1
        int[] index = new int[26];
        Arrays.fill(index, -1);

        // Time Complexity: O(n) -> number of characters
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            count[pos]++;
            index[pos] = index[pos] == -1 ? i : Math.min(i, index[pos]);
        }

        int result = Integer.MAX_VALUE;
        // Time Complexity: O(26)
        for (int j = 0; j < count.length; j++) {
            // only check when the count is 1 == Unique
            if (count[j] == 1) {
                // only get the min index and save in result
                result = Math.min(result, index[j]);
            }
        }
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }

    public static void main(String[] args) {
        System.out.println(
            firstUniqChar("noclrnthqqganujpsabdjjrwfljribdbwoskcnmtxokkrlvcvsdcxlcqtmugwdedfebnveivovwmkcgncoqslqteecmnekxqkaguebafmmldalfxjexlpiebstahlombvkrpwglbdkbjlmbasdbtrtexubjtepcngbmxujktcipvlwuqvngutrlxkkhjwmsengmdmdesjogpqblacifgtrlaewrcqxtwkrumhusxqmvqlnixrnghtejkrpxmmowunkkbflujojfpcclgdltbcsinuucsjctfxbgcpkbqwpnvghtlgerlatwcsekjhlbswfjxtxkufugaanrblolofhdamiotwqijtqtjcdwgerhkwuufldhrrfiisihpwtsmpqdhnooftgjtcufjejvuepvauemwxkmdaosjdqrcskmrcfmuqagpodjckdwxbgrmqshadaadsxxoawiwfkslxsuovovsmhwbwdtspqdcbddctjkxvwaxhticlgaxbvwjjsfcwojxbhxtlubipditxqtqojphoxxflqgfqlkiqtedhifrlkmqvpnquxdjuxbutlwfupxhahsrbfaajtknlbhixkmnudwojterejauhkqwakihrvccxgasoijeuetmncbsitnfxngqeqvnckvilwsgjtdnorkepwupoluuhrvcgqqthasovrscpbcqautjxjwaxkaapenruqbhficupokqccvgelgqvjgflqxsxonhhqpufsndahsxbauorqbljpvhkmbbhjwdhkdxxwksacjqmkiihbhblccvfqhnptxnfeuktukrwqijdpbmgwokumwxskbgpnjohqtucleruqxfoaodwjxpsdrgslwnhpevhmhnsujijmnrgniehqbhpasbwthrpjpklajovhjjnkkpbgwibfecjdkqnsmdhtdgvgigjuljjliwacbwmosjkuqmwxuraexqlfnfqtpklxmwucrwimbdqkfelmhfqouqxuiejlglmwbqtxvqngjanprilxgprxbpauacdwieehudxxvvugtrqrsbgjbvjqxeofopiceoueahwkcetcpvrrtnebprcivpjpbthqdisltvccefuduuahsxnbjdtjuarjcxihvsavnubfsbnjswfkiejxgbdruqofjkljbvmcxmfvnximlmimuoavhfubmoqjvvqmhqajrwfinptmuvjdpecbdofrntpgohxridtusirgjsaiikiiaopltngboftlnaiaexejdvrbrpobnkvtinpfprhaqgvcsiercdnbtcviognxtfilpatowcaqswdjmqjedhnetrncqxmcldkcuqbvjijhfeocehqagteklbraglvcffbwpllthucoaqplcvkguascssrkjbhoasxqbtpqbntfekefvtngmnhvafwaqsthnscikqxmwenlrchxfalihddtwbwjevpvdgmwrqbgppgcobpdlucenjwmuxkwvsmadvdcpfxhlqhquxlhxqmjvhrqjftqcrsamhblewqilxrwscnuqlaiifshgnhntlbexuvspeuxpksmbmmcxnwbfmcatpqfjhsoenhpawduotmsbeibthvmvtkepjmkuntekshkiuvjjcghbtbinxxjhsqtcfvkdggprjflpgcehfxfjqpbuadqmsonfckxxjjxturbuvcprobsktccjxrimcksqrlpqwwtnclfaafixulxuucumwksokojkracvgmnsdtxkalxiivlgeixmuewtdjtekikgidlqirptdugmrxarskskramkllivfwweecwpqvntubluxjuegbxvgwtevmqgihvxclwimaabaaqiklaqrgmgchnawddpnuagdnsdsqcnjllhtvefshcuvbipakipufhsoiehmxbjgqnkrqqsrwbiaofacbjgesscuekvctwchbfqusuixbascmuenwenvtaherfucwitemvsvuxotcrjlvutpcsepbsbgivfoobcgtlathlevicnupxukndstcjhkhkhgvhxnnqrxroewcuiuelaghwiqadjrpldicdlxkufhebevsphttbwsjegwjaasbbbgnvfospgfwducpdvsubxorwkwxkevdnihgfhrnjjqjgnvjxpaxdcsbkhxjxelhvquudoblrrjeappqfqfmoqpxatjwbjllblmcgnfealpocrhetwrlmjenkhmagdfblpxfpjfiokcjetowcrnudmbkgsjoojkarmvwofjhdeteohduktahujwnonpqttjxedhfdhcjhrbhplwxsrtuwbmqqhhoukkiulekgxxpbdmcbxhxugumduscvraaqwocrvuoooihlhmncupvgpfvjkblekkoaodnlrqxfuwltpkidjnhrxoqcbadplnjutmrjwporairkdveupbhnufwemhkumkpuewovfjutdodhdfxuouusougxjwimmarhktmvfhiturxewdcnnvvholxvbgvpeiagmctkhajquaxxmggvvmmfeilntgkftqkcutulkujtktkbgxrfvjaepvrophvvkcajxpvcpuhnptikmuvngvreirirxxprivdlxvhfwhdudobsfxqvaxpvofkoqarpokcsuvlngnmanxvrkxuukqchsqonnkjaeiuunqpsigedfdmwsfaumhcrecunmlrmjpdldvfellstnuwcwautxmhutluxvfpswigngmusqlxctjdfnqpclhbqhmwljqvuckvsewdoghrgxkdxiotapjifjutrqckionqmqsewowrqcaoqpqppejecbujbbnoxjjxsiqgtxaxplsfxjrtvjigbgkbtfijrmhstvrjfkvlndjwohgpdpumabatotutwgwbaglfmhooqcdldirurwpiqrwqduqmnipmjujcpvkwjhkcxvjapvbqbhtgsqemacrdooaqhfbvatvvbvoenmqgllxxtoilftuhgvsxewmjvffctjjrkfojnukkwgvbneawsqgpojsupobltibfinsiiluosjsgxmwcdjebfndfqnrxkdgbvxfffhwvrhaknmvjpfvlidaegdowqkrosjghjiqgrhfwntfnogqojlpasqxavebdotngxqirtktiqshmsentwmllmdufjcghtglswfiwoqcsgrrqbofiqxjelvvndljuxkwlfhhneaikhpgqvnxxptlljftiuqrjlwibvpgglkxctedeuadokjqiumnomjwoxcbmwvtbepwrjckuwikhsijmvrmxtnbllqamaqjohpwokosxvflrqjevevwljmqhgfnsdjnfurgdxdmxiwgmktdmrqfdfhofcmaewprwdwwxnhpuguuajxwbtbjfawacftslcdmsdfxkhcdmiguvevtflirtsqaxikkihugpnphmunaqovodfemoboftdofmlkqcfdixrdrndqhaaickcnrgvdnplpxjnlnqexrqpcsnnkxefirsmxqlhwbncmxhqmiudrbmhuuukeavpucdllthhacpxfmeswrnujjciiodkndrennfpbcjmjiedbwkmqbcngqjlxqquwhsvdlrxxlrpirugiwpwlofpjwtiiteswuwjvlvuqiwqvphqutnqhlnbjtpxegiswdhcegkgcacpbbvqcvkjlfsvpqvikjkvwteoxkbnguuumqwafnilpwmjtmfldnudvuuphbbrttuovsswdsgmevlwuqxhhbvdlxjdlkbscfkwvsbtmuuvskpucdtvfvupjdctmwdxssgmlnlhbmknqorlwfbvnclnpaxwsmwrudbaqfqcbqqgxaxtigshjxbgfgaouukiqxrcmrrdgdgggrktppmsougcbgvrlhgefoxjwbulnsuowxlemhqaxrciwpoiwuuntrehgglkjpcoheqwpoxxkhfscsmtwltkthocohmixrawiitbhvpipnhogvnkcudenixlternsaogbrkvelctxuifjscutqvuqvvriojranvfurpbpqghkdqxdbetiohpvnkgsuddjplngibpifvgpsxmwjjfkpsieavauorugwcmsminorgghbgeaccdbbgwuxfiemkmxtatwptukerirjtwruquugeinjugcpgltvhjkamttgvugbhtkpccmocpawjsahfqtmwipqkmcamsnjldsexlahsdfxemtkhvwregvffngcfbxkfosdjrrtkudsvdfkuivdtelswhikqlttxeksxkgsmrdjmqggmspsskjulcacggtmiebtbpqspuuureogxtnwbirnvonrnlmwixqnxhxvktpcfuttwchiavqemtipgjqignobjusspxudglaehbuxxtjbraavbcxkeougpmskfakhvidjtgfmwacnkowkpeambskuriwumfrhtkvddsjgvfdxjobggjepnaxthqxaeqskosvrnnrvmcfhuvksqxlcqklubeuofhfiqietdhermoqwnwrvlguwcwawadghxlbcpubkmptlllllcqvprqpjentbchmstehhnnnvxxnssppwvkwramgwuoxojoxqxcxhrmpmonuwcdlivvocsboctljetbpxumalskaiisfajhaqcrksgishbsetshdbtmkrsfqavochbtfoewfsurxepfgmmsmocaguafouniltrodkdlmrumiblkpwdqjutrmbemceicpvikcnxbkhgadpprqrgllveotkwagbospuqfjgarvukwinkujofrbrpbuwgdpkpbdaiarggbnrqhatdbbeqtegdqooutialxkjisrtbrmvqadbukrtgiuopfsijrxjdteaqfkpslhbsmaqenatrsaqnoawlempvpkmqxdkxvrlpsqqttxfjpjnmlpqlwqskbmwakntrbhfnrchrdoqmqgeuopnsvlatkrfqmqsbfexocxhopufdnaffncvwsmtokkjrflhfkopqnxhsfjswooipsfirnmtnrgsrhwcxxnpfcranoorvsbwcttprgcwxgojbqtmogkplbvapclsjdigwrjqimpodtknksxvjnnnmjebibxdixmjedkoejkddoroctvdkfntpeoljslwuxvvclewhdudgqlfluliqgdidiseqpxldcsmjppkatfiejsblurldaovcgbpwocqhsmocqujhrebfitsufqvdshrlfsruquxpncrdgdeumkpbwjbfnqniwwuwpgdrvoisvfhwrdshogqimkvffilccsglsnweuijcaeisrnlqnbxsigwonqhbxdacxgsphrmwhqcwfqphkkjptouhvkcwfsjugkfbesqgbjpeonpevciaecaamlthtxkxxarrukokawwtumkaoittnjrreokftbbucbnrxcmksiilpmbjunsjetisdjqbtjimoecavkvgaguupfkairwtcsmlcuebuopvuchgnbgpcrswtbpwkdghhtnfbagxwrnaekutqxbdqqsjevircmsptbdwpvhrisrgwfrphnvtruvvkuddqttsfkppocwrmagoslpthdcqxucsfukdejipwwareatgaubphlfvdarqijcaffeqnojapogckoxxnfutooewsvbuvdtqsicmmbweokseavbwtdhjhtkhdjsnvrpadulojkiddrdfgmbckiibstroxvnckmgkblhgukgnqmjhlmhdbcrdhnbewbjkkloumchuvjbktcfbbfmbcbjxosisieopxxjauljidwasgmglgohutojnwcihnpfixppmagisxkdnhbmetajnvjhfaujcujendmoksljcbesdgshoxkjcqjnxmqbfgtgwkoabiqgabngffpiiufpmlpllkisptuidouerlagfpvortposqidlisakbjditfemfhlcljbhklsiptsmvugintestwvqgnrragumxmaxmpdtscdxjrxblrxmofhxefhcpsxpjacolkaaunbjmooqcfsjtgjnenppkkmdxnpkiubrflmtqtuujomhkslshuqripuqsfqnsepfufvnlcqukvnqcbognllgdawwkgmoddjtcdtqpicktcwtvsrjwjoarolfpqtubjhnquokcqkfvufhbnumjhlflbcgquobnfsclixnfpjniufghuqfqmspiadxwsuuppjkoivapigkujlpxvmwrbrmkewrsrvvpqmnquaccrsmjujcjiivvocwpemnsrbunaltitrnukmdofoxugvmusmurrukombjawhuxgxqgnmhmttgcokrvgiggcwhaxmurlxifnsdaxcalgxxrrxgsrnuxikgovtvrouhsxsnkthwthcskxfkjmlfltroreuufamcouqalwkbtwmqnhludodlustgbukkabrhiftmntucvswxjsjgiqdoagoigosfbqlhcsuxwqdxpehahhihhrfeiwetikwghoidksskpfbccexeqpoxcsboelupohvglckrbwffqlwjwrxbcsgwptgeumxmcgxtfurdofvaikagtdorohfuxluohsddcofhnwtqtilebjbqiluktovkktlnxusshqwbkgshwpwhjjigobsotqnwqcepktukqtcqwmgkqjotrjgcfexmunnbjrowbpqtxqbgxrnijxmwbcstnnluhmwumhrqlpwwshmsgfbjjaxcjlejwdwwuohvkfoxcuwbsxkechrniexfavvuipjrtlawtdekefjopaemvxwmvnvrqidmcqdptckvxadqdlodbebcghwwbjxnhlirfxvqntemomdlfvnsiqrwmumtmiqrgpudjeokspgrxjvslmgkdpmqijvdwlvfmtwkooggiwjolmifuiskthticmthpsqjlqghmgfuxhescqnmcibeiqfojfnfoeqvrnmicdumbthvutdxtvrhstldhftovrwbatjprochebcpbnkgqwutritnseolcdinokusroxdbsgqihssjmjquwhwljvcgpbjtrvtsmesqvsatrujwgboeoxucvqvqqwvjanqeqakrdppashmovsfrxrjpxqlcmbcwaltwrlfmmefidmetipodcpdjiudsdrgmjxdrpokaxbksdjhdavhkobmcpmpbwolrlchwuaaxfwpatqopfgjnmntifiwxnbpwukrsfrrhnmsqkjsgojnwunamsraexjuchkaincmrqsndrsckmgrlnitofovinwrpkhupjkbuvqwrivnjwopnixuvhifcwjvdftngujacvhxcgjvvfqfeujldxoqdlicpsntgmprjqwgwlxbmiefxkgiogigldgxdgngxrvucfvfuiobxqtvqbwdptwhchimpdehbfcbfnnlwfovfvlpnscuohjeipqjcrjmunwakxeikkxfawhkpurtdrqdekfgginwpeccrevdafkjwmmogidjvcdwxjadbxggdxfnjlngkrwjagmlbwbufsddstpqugwcajqdlfgixmmvgfojsfcwtqhmkbefhgnegirsxrpbwptnqilqpwovxvhxcsxdbhbsvmsmfibcabtknajqbaotrqmobxxaeamguodpnksbvkespmtbamrgrkfigiufokoxvgkvooepvuhxuvweubpaockmkewlienvgdjvbvhuxelhfluxuqbarbeentwqkhliqohwggkrnfqmbvetjrwwsxshxodoespxswnsnsvmffxecuwrmlwcrluvavfunwkeomsawiihqmpboxtxkprmowkohxmrplsokqgarbuaotikxhchweqmahnknnbxaiswxjrsfnirwksplllipdksapmjkhmvbwxkfxugdtmjsaoadupbmdaogvqewellbultmdgnddqpqwtuwcfmofjiccxbjuajclvbunifnovfjtkngevivqnamwdbcakxckvneuqpietcfqclbdpnbfmhdaefcasvlcmfnbquwfaomvdeigulsmhlbaqtjtwtttrdptacvpojfrvbdwdsxmfvuhrvhsabcuevklgdgvetbebcccnkcgggnnxjmeqacnovgbenbvkmaqghedjlrjlnlrqbikvwrhwbcmkcvaruskujdipnnglbqmoesehfrcutivoqufquhumwvspavuwmcoartjolafjcwlkjeeikpovqljsnlumnkgxcdslsxbugngwughhpjqpfempsfooequcwconqvwfxuiqjclhugrlxkeojereambbnxwmxutunvhsiidipobavlqiiiomdofnpejawkqciwdljxvqkbrwobbebjuqenxumxqkeiggijfmmrrrlhboekgkkgmhelqqmjckdofjfuvljmqtehqxoxitfbnjrwhjakawceerhpkcqrkuekpjuxxgraaxugvwwkcqrreahenrbqwolqnmoukdwemafnchxixxqhvodjnhfanqjblbeuckuvcnfkveunhmpugceiluktotnvjpwqgekksusewgtjmforxmthoijpcwjtwhvapqsflpfehmoedewgbmwopulvbjfvkhxempuuoopcngdohjvsmkphnxwfkupbojfdoqgakhhwlvewwtuxxpfrsjugnqiakfaxutbrqmuxoqioqkeddtxdtlukluisncwoxivpivqhjpoeoolpxepoclgxmbxoaqarhqdrbikekkijqiddeuukpujgpfoftpphtkbjdhcxjsnvnwshrsghbtppnctqnpscmwqnhbhaqovpwlkspxnujspkoiifgrairvbwnhdgepibkmkgosrtxqrojndepfdldostuqnlxmwrstcrndckkoveotghqjsjjbfofmvvbfpanpbensacsddvorauahvtepbnhlufkcmoebbgviucqpdhrainioeamxoktoalretsxqrrwmmemcwcwxiqxxhcabtlrucgocfwvmbthorwvfsqoghwwbwpinciincikulipfrorpmcuhqxqgnwmujiwucdqkjpvdtbeecquwdobirinncckqqnhnldksnmwwprvakbhlaltrdtuggqiwdwgjfponihgfvarssdkhjasbqiwwrjvflkbxbqtmqambhfjasegrqxhahxlxtncfwtapnwkwhwrbukvelwtjugcphxcifmohwpebsalteluntvmothiavwkfksurnvssjxvwqanuxvoggpgmuawvsxishgqdusfwrccnimiqpvxtmqeanifqnrlwoupfdbqeekugqnvpodwuvxwknburvduchdihatltmvkkcdebdgdrbouqojljcxsfsnmkfavdavviuoexwqqdqlemhbdxmtoaxalfqxxfqimiaowippcbkxrviruumiacwfeqdcqimxalfkbfpuumasreqbvhioplxmpevpbmljbqstonehukqtuajjxqruedsfwiwxrbxqwxjjvihqsfdeljcqcxquodhioewcriikhjruvoiwxfcdwxeheflegkhmcinqiqmqwucuoaicladrmdnoiblfdaicinlihsesatuqbnvnnqaggmgvmdjhgoucasitgmiiilhronjmwvhcudxebumbplretamkuiibmoliujcsffcuegrcodtnfhrijghtsgvxutrseqsgtsqwrxcqmqijaldfrmjgxufarkpsgcixpdqgjgegctkocwgmukcveecvdmgxjitwcbuvnjnurfjeqamgbrtoqokorioifinteddsekpsifflfceqraskmipkugaodvfgernpxrqpaugcwkondpbjieqllxkrtmlxdmccnesvbjulgtseipgttcmhxkwbepxvqckfpnescepedsaephdafqvhxplvhvbrmvvwmtgxuvxoojiwsxxpqqslupqpdhjdwnmofhadofmbwxcsoqrbrbdswbhnjtathrnecicirlwutepifjtxdeaoufpqjdejwrbkcoummigbxjvhpcuouxjnweaqkxgmvnrgvjwbacsgpvvjttmbefoagesuevxorwlrncafudumwrqecvdhelqhravgbinvudjlaisiktctslmjepbhelfkkfbeofksgmreoeumhqwdtntqaswstegihnopgnuegkvdiuxxnexlcpligvkqkwtlipupwrvffuejfkjteouuppodaaojasvbotemrjmdlsnhowuwdhpgbhdxdtqmohctjcenftaaxusttoojtwpjrgkncxbtlnmralvesjdrrlcvlmrdulefgfcnslkuavksuwqxjkebcwvpxamwnxgcjlnhgxbanwtquutxchlhsgdhwqoqwqnhcqccuuahrijbbeqlehisakuhrwjkaqjnaejqujgqemtgsovvqcluncqnqjuetxkmlqtppwcniarhaludnautqoabbkxgomauedwafuwmchldtkmhmcehkhknhicakpeelwltfjbwvgbukdfpnpjcluhhitnbhqeoppcpiitlpplanxplhpmtcnqjntqctakqbamofgecibjqgmknltwrxddjnjddrwmtajpovnuvjmdecnwlasnnevcijmwuhcexfiviqelskrjeuxtpontpotlnafsnovqmaxeefmjcchehcurhhswhqwasdkvnvgkbioormtonbpshmdqejlimpfqfknafnfbpgtbbodkljpfkluanmxiioqlxugunvcehjaxctugmajdrhqsebhvbtiaqbtxvwofobuxncnixofomhgmxhkbiolbqdodvxjdhairkuwbnejusupihaadnaevppphmjrobmtfbaxkgrxpvvjeejslxjaumaecueiwdnvdrpbrkpgottgkoeoraqbgqdpgtpfdguptdrcibdhbfnvqfjpnwwoudthsctqnkjpvivvosxbhdmpaaqkhctpmnwnoaxsfpdpjguxtgtekmilbapramvfxgeishecjntpxfncwfhjrkardnrtgdphnnpiwnrrclqwqpjfrprwftusfxmasjhopemfkepvbclmkshjlueneionjwrbvuwitjfagsniectjgaqfelwgpjtcgrpvnvdxdnsqkpmcftbovptjmwpaggojvjgmmegtnptgpfmrsnuswhrftlrtjgvduoihirrctrhidkmxnpwfqcsssljxblahmqlftdswujgaqqftnlmafgfxhfknedqvnhholujgiajgufwwkxaruvtvttrmmpvohlfdckpdgoaajcaxmmkluntcwtruxhwjdlndpwumidkifotwsjjlpxwabhaghcmxxqgwkqhrnpifslgmwiwdmkdxcvojtsgofciethqsfjjapxrhxpbctqlflfefkvvqlbfwsvbqisoaltncwxbbehgetrccwuqfdesthixcxsgfixkkriwhpalmjhhbgxqlufkekrnrqrcinlpjbsbufdclhbejcnnmwcthlijeupsqkpvgofcamiftmfidsqwhqmfwdvtlllfnxstjrqaufhbtqeugoodnelbbahugopehmfsdquuhaprudfqkwqgnbophdhuotjgxbisdfrgjgjtnfslptwexppoangkkeceuplcbopftnnxwobngdiadgmxmebhkxrfwmglwvgrupdoxwtxwhfqsogjmsdkpoisgjqmrqvtmltabnarixxmlivfpwlehqvctpcosjoleiemddqkkumfpcrkvxiuvfbggueqsxpadipkvjsdouflmfjroxttwumoncgdqkjljcveafqeerkfuswkdnurehgrkhqgusddoodataimsccehxbetrlvwvpamnrkgxxrdmegptdlkgxhlwahptiafgocmtlhhbdupexpkvrslphxkvlnotsrqcmijjmmoaqflwlkonbjwmtlmomdqbcbxcrklgvsumgeokrisnnxsvdmparmnnaxkunhlmnahfvqiqbjpudnhkwkfkdwgheecjqhikwxbufcjadeujesftgefwcjcawhwrjdkqwgcxfbktgcjwqxnqrkitoocwvrwvrlrwpwihogsxukxkxuwjigfjxfucdkdtbwwvxwffbijftnuviibwtvequvsvwbenwvatwpjhlaigmllhelvxccnappefppbjdxhbwbcphwoqxljqmgsfetjjwsamfldbhvmpftcmmbtnunqjnbiglqpdsxijkwrmrhggvwjnrjqeksxaklqufsipsftdmxtccmveurnupquekcowkvjntrstqfcefhkscecddnqqwlhxuuguuhdlnmxisxmddouwjrurjkrjgnsmibwajhpekuxxrsbagtuvwqlqqpbpgddtwrwtjqmkeiqgvhclqhxxtmahgmpkxifmvtxgeaserbmponnexrxugscgectkssnpphiasarkkwdrlnvdvcdvafrvsjfhvcvusgrasxkthatlogpiirtqjtgtiqgcqhmtxidanwejxxghnjntaxigbmhcoqfbfjsnomnxlmalestmbnovxmbaxkxbtqsvksiaothvecnsujdsklsempxuuslrajwhrpvvjebsipdmaovjatcjwqqtaofqflqnitsnvqmoomksigjjkmffoqogdgmxcnqbaevwlohrartmmmpsrxloupbmfkqwhihjisqclptluvvktwiunlnwaupuwjswllupsglpudhudbanpedporktrikandbfxgxkmiuhardufmftwpremikpbtrpdbfnlljkphvjvkhmjhlojpargrwrwufjqlpmpqbolmvfevekrbcuidshwevjrdvvuqoetfxqigvlndjilllpkmphcqxhsrjnobcdwdlxvwmcalwuqnfobjvplwmdqgjqqfudkkwteeceegmahgiidlgjjvnfnbghanldfrhethxalukkkhnpjbstdwbnxdxqpqhdiqptlxmhtmiuihlslexhtqbdpdfuvhjltbewmnixnhhnqhkrqepuxuuhfsxtbkhlnkrgnjurqegulgsukqbkqbsjqqngvaudpdtuqkonwmvdbnmdpiorwilkcuhlxcnlknmgtbiufwejjdxoqovbibaqbwodaxmduxtfpvkupdeovrmwnpwsilqvwajxiqitfsacepkxkkmstxrjgobeeplxbpaoxmrtxomurhctoefwmuiicbpxvmcikwepmeiersgcauckfjfiibrdtqhdltuwjttmbpemcpwohxitvqxjpfldpucqwlrdnwaumoffdmephpgficqbrbgoxnohfnjwpiqpwjmvecjvamtcmgkbnesgtkwgjbvxxifuhhagureqsqarcfepuphscuhosongviovwrrwvqgquresbgwfokgjgsdiafpdivubnoipnxwvqxpntsbrduxvvnjttnvgsbwjshuifpmxudscojefkfinamrgdhohbmmdguvrnqagbndjtcphnhdbxallhksowgoqbeecvjtspumccvsrkphbrjajipkljonisxptfdulfbvftlockanvioaigffgseqmdwreunecftvdgedkfauvcxjxjouqqjxssbhvdijffleskqhrdxejinvijhnhmvdtaxdgcefwoikeqfmhtwnjsadsvssnpptanbexbiqladahawruxfavaiefxxlqgqpajgsriuqgstvvkrgiflmorewcnfocmhacdpwkocpwwsjeghetobbkhmtpxvvjqnnanextmpukknvolhcfroalqbdfxxqhrbgbvmffsgaehgxksbrpqtaxfdfeukfliemfmhboinkdfnspmhxprxbagrjfvwwffgvechkqomshejtpwgohfteukdpwtesnqgevwbqcdmqillebljovmxqntlqbgmctjmwtbiedbnvomlmvcovdokvspptewvvxxkvlusnvgwijviutsffhteedpxqjkqlbdoqovhtxdxcrpcklupotcpuxtmpheuubnqxmfiwjqkkoskjwieggfavasgbvckjxnrlvdfpleuqrnqokgdxiksxvgeofvkbtlqdcrvvvqiuakllqnnaarllxfgewndegwgqjnabhfuxnpuprpjkqmtaeifnibftwatamaacrjaaovlktsquxktpfpjalljnmpwnbkkatmvhvupvpxsgncdgskkghrxcjeqhsljtgitfaeqhwggilvchlqoneeolugamvslmambrbepippelxlqkbdiatepxehxgmjacdxalhnmbrbvwsmhvcroekrcodvmuggjfvshtbhgbwnjsexfkilrdcsorqkixlswwinxkjcgaftxnggkbbbqeerlptmdwdugmcpiagwlwglirwphahslpomsqllerogkpnsjdqtgebnegoltjrqmfcutecbeimwrqiusfhqgjoqcsmcqugrbvwanmhucefguwcguntgmwngcpsdtxagshmkbhlopebekrvaptvvasgfvmxawugxqudaoomvsraamraccadnrvrwlschbsidkkkefidkujkukptuwtooihojdanrtkgusudmwnqumxixlkgnsvgpubwfgoxgfcaivpfiafmfeiaiatjwpeubgkxmdfiohnoannaktrndjgeaqbmpncoefckedmaaqirmsnuriqmhfikheuiqtpwicsaonlxnqvheuibuhskrigufdmdrjrcnnbhsckfnblrhbmxuhifrriabokgbjsmcfhbxscciikpxmuwjrrxorpieuvkrartasnnhechwilsslfxsvvxkqllpxnfjbhpiossqjssxwnajpbqbcnflnsjpmdjrsdqhwgsdqdecnqduppkuqhasigshvgurlvfqnseqsuoitfcclpgmqgspkoogkgiqnoqcbuqhofgjqlunfskbshcbtlftkmeqqurucpgpfpgvvkdtdxqlnuiccmppohqptkwpbqwchjmuktovvwxskmuiqjukoxdgovadwbqodtkfgefdeionaiheesumrmhntxpaareerghjkqiepepvagxwhqxnxxdtphtwpqtllblqfuhsqsjccqfvjkoebxhrvfnmnxlfomwsqkstucmuvwrljqplpfdatcldxvfqfihxdjrqvnadjwewpleiqiqwjvxlqtcoolagvbejdsfgqcmxvcdunaetaopuwpanbhjjwttwgclghstoifgofvqbagngbdrfheaohwpgmukljeptlfdajquxqmhasotqarggalglqasftskgljuqbabubqpurjivlwtaqikdiwduaelgdrihmvnbkdmqnlhtjlhgqpbpnhoaoacmrgpvtasgeugvxuidbbdwainxgsrinqwqnwrkvawcglnsovtvupncpjeslhgfwlbsaeoosnlhbajjdvaqjfpinuacoptxrksrcngiuiadfusqgmhgbmhqlqqfnrcwvebhsdbbjinpbwaiokavllpubgmmavbrljwcjvxbbvcdgptjlqdwrcgsovtxamkkcbklhlianhghdvddofabqkdulvhvufexdndcswmgnhtljkbwxcpgckaqhhhiwqxrweshnneciuaghotjnvavxkexljegtvdicwhrorgwgpwjohsvjqefochixvuqvvalqetjwqeijxlughhkkdbhatjvctiwmhgehvuauuejwmqhooaaburdvukmesaaquvrhreebuqiagfkgshxwnsbuwsggcunhdvdcbjvubwhnoleqntoqwwbfqbtqtfxeuwcweffgkqevlqwrhdpivuskkatrojenpigdsxkohvabvvquwbqnmdgauvfkkcnlnmgcuovnbntrflsxemkqkvlshblkpocffaucbeolpqnecresqmuqqrrvcndkopclpfgnbqnxjgotmwfolrqgvpsuvpwswmxxmmvqnscbphfnemptulmjbhfnjjmjpmpxtmqndketcdtlicaqtsskurjifruabbdluejunqekjsiulqbvaoqbxfhobjqgncluawgnlesbfmebcwcumqwnbdxpwigmspwjojjhexggmbxchekcgwohlurkkwpbrqwmweasihqjasiojsckwbwweguqadtobnbsijlhhnplrfqobilsnkatuksqvpccswifnpmossvuwmibnwtcsxsflbbtlsdoemdnmojoimalhfviqesdfkufcbsrrexcqncboomirvjjekckpcsfpjasquvjqfhfvcmckaldglivvbwaebchxgnovqsdwvjamdtqaspawiuatuisohbsnaswjhaifmfctjnsanpojdwjwsrhvoifsxaefiaafkneuklatjfwqlhbmtrpkehrncxarlscfahfpiveahxqbsnixxadudvvgdhbtpohnueoskslpnolpxafgogtdbmknrpifwmwniupxpeajfshhssbkqcwaicadurvgxtqocppvrbinflwdtjdbfvfrhiohelhpkvvwmvhvxkodpjvkchmwfpqboofkkowwiauqfvowbxqmktpvpcloaawvveesurtopvgjeavqpxohvskcllrdoixhecukdogmqusllpddbebucgwtujfuageodhuxqtwktmbvjpjapejtahuqdwijelvlkefdjkepbxkqolgorivnpvmirqslepjmjbhvpralatodssdgpiwjxxvdeqcbosrmqgbnlrjhcbugnlqxrmtiqgabwobdumeqqldemjhcfrvbhhmbatvjcculvkwsmflspxxrbddmdkrfioiushmugdkxtdcvqmwbwtkmeffgkoxrridbrghjsjrqxtfexsmnghpnmaexetioamwhtbgrhlsdaqwxrhopfllfjmrhactsgeiosqtlodncalnhwldwfhrtlrtowljxugsxmcdpvpjuwmtmoflsfkhqkglvgwrvalmrtrrggqokkkambpqtmgvtwfadasesutfegtshhoodmxdjppisurvmpmlburcipvfqnbjksagxmrnkawdxuemtvmuocrcxalgohduanqjgcbfxeuciuhvrifksstmfbtnvgitisevbghmbubvpejnfiggnmosejovgbshkinsxjskhoedlemhqwrhabubtiemaipahhdrbjmgrlgunmorqiuochlmlomstmivvhfcfptiaupktmqdpiasdhvjddqaplnxxafmnuqjdhxcpucgnefuusqqlpggngwvscjqjwtjcggxrftcagsmupuclkhdmfsqifsvphexoitxiffwsnrrdflxuutiublaibimrgtuwuqcewgdcqqlswuonvkmgapekxtmospicmtbvgxajjimijoxoouajmxehfcwxvjclhfuepigohrjvnkeafqlvdtsgegktwjsifgkipiurclfkmqtklhwdpstpnaxknprrwvmrarlssfwvvxuvrrrsposlofwfsdpgcebpjjlkxbujabqhnotckverrqosfudajbktrjdirfalvuwcrgumkqujvaieodogdfwncrmfikkfmjpvmqfhwhimbmlinihjiigddrvimajgoitrovolojqrhniasthhjjkhmrpjggfgjbbvwnxisqnqgtgtwuokesrqvibimgioomkbwiohscpsgowbxktcsrepoheoiohvvavgvgghwifnxoqdwxpvmxkcxoqkqxvmpgdklwfrgkaurktaubbvammljvumojijkgmaqcmdlqxemmiihrrsaarksuqvamigiaxveikplbtpakgujojslskgtcnmixocquelibpvxhmennwtjsxhamxpfitjntkorjmbcunuqijltuxfgdtjbuxfookewqdrvbhpdtsumncfdbctccggflcraeiwvostdsmolewffwrjtcxmmxqimbjkbcapjfwftfuntrkpkclafinqmcaggveqthqvsnagfjpurivdstdqxtfxktgbtjslfvasqfagrqmmxbqrxxolllgkobupldumgscntgnvpilmmglxaxpihhraqvhtgeksqxtgmixuxcnuxvnpntuavbvkqpkkmmtocenojdpkjwcfsapagsfseptogxdookphmaielwvaverwunqldgdgmckplncosqxngnercdqmduthvnrpenofvsdsnaicbetiabqlhiraefhavpcubifgwxobfsvlmxcrtnuuqwpugigcmvskchbrbiclubqabjvpnjjexntwdnpeknjcpcboowaaaocbccmdpexblfvqjulhxqrljawwlbhblrcxwjfdjiffdnmckfcktwpnwliqbjavujrjeqdjedmpbobkvhdvwxoraboeaosmcpgpovuvwgtaubdsblpirclwntqlbpooxusrlbjfrrdpuldrqbnmsbbehjiekwmmkofqdlrtddlurhiirbgakcwemctqurlvdvglgnvhgoeakmlwetbmcosngiefqbesctolmvuprqgbcjdtbxhbjfghebavewwspoexnnxnekikgpjxiuawowstwgkqkhsfkqjpjlvqpelipwvdbttddtnalpimbnhdlxmdiihbrggvnoggembrhkqgvdktrjgvkegudtnpmqciihnjkxrpbmcndebujjokpooriwwcpbgbrijljluvtreofqvqdnrldxfcipsklcljocdussrlmjoqeinoopugmftqmhdqodbpjvcewcjcetheoukwkobvebxkcwxljuhlqjpudulbtahaumdqhriqrdcaeeomeffwvgbttqajjrhgoxbnwrqnvlldribbivmpotcrmvqqxthwfpumfgkooqtsithulnegvcpginsjdbogxcdwvpglgmjntgbvgfnubjkdowprgcnawjgrwodcevgfrhhssffpcjliwjgkbnueiuhpjbjfqekjkoafgfpsijbdhgidktsqxklqubrlkbujonnorebsttvwlnuulehwkfnkjgtncdvfnsnlvudrlfxabvlocimgqlkhgagciumghhbojdowaqocjqvarxbolvnxnxtcuscdekignkkckmskeujkoanacteinsbfgwofeddmrbodjrelqspmdejtfuhenkbuwijkiekxvpttgxesgrihhluiuchcphdoeqtugmehjorchvjrwtudcfhnxtudsjodrfdtxscenehovemxjgdgmsrvwifwwakmtijnuptpjsnbruvunmlcnruvbjltddaamjomldixnqmljflrmdxofunhrgncblqxsqcawnanjvecpxgnmtvlmbgcuwmmijrcpfehupehgteikbpapgfxsjhgllaaisuaravduhepsannjngdldrmxmpepdqhsrjjsaveigpfxvoxwrkvkrwcujhtgpexevxwrwdqhmvptkiaiwugtrhhpbwlcxokhnwwokpjjjxhqoshptlwgdrncnnfsklqukhrjucwwffnudvvdsqwthpudlminsoxjmshceeqopxpbxrjebcvsupcedkunfujqtwjrbmnbalhgtntkbseltrjdpikreaoawugwedixqumthctfcqcwuwbkgfajxauqxdpbfaoapaxqlpcgulhdxgaixkbvfufsmutceujnvxxvhnhlhmtseiqmlwkfananghcjbhaujsucstcvscxelviqcsvrglgbvlehdilgvrwpfkufogkhlmrldnbrinowaackmxtexlweisuruhunfosnqagnoeaubplesopeirtjlcktrgoujdtgpdnvqheloaxtgchqxlwxwchrathghsepjvfcfptdadprhgmpoiveadknanxjhlowwxpshuemxgkehxfadicjkvtwimhpixauoijpenqpleqomaknpmnpmhtmbkwpuoljabfxvkvcttrwxxdfsmmeokrwdueajpnwwbtusungjlweaeraehbkqgnggnsuqdijgrrmctiudfpqpjtofweirsptbdokisuujjbjhwmskbsjudcheqlvlgqvfglclcpnpqcsxotkngjcwunlswatmlhnlxgmhgdgxhfhllfcovlaguekpxkjfjnbjwbqvuqndfjxtequlvimndhmdekxoxqcpctpfnmerdgegjgpwprwqahsgfxnggtixtuxxibskafnwlotfdfoctdsxjblxgtuxlnrtwwhgnecrcraaqnvkvtfabijpocubpnwawetvbnmqvoorgpbxgauhufpxwxktkemhrkogfqrtffvgpntsvjgfdhfxpcewktmqoiadbescrwnrixeldosrfpmormebhrhdwwrsmrhuccgaeddcxqkvllsoluagsweqjfjmhhjliqieqdxokomhmvqngscdldkowuqqjhwfsblmpxciticijnpejojrbhlgolxidqatalacxnlbtptqsjwlvrvqfswqitmcmsvntjfeqhchscxhwtmrbkwawnduftjhvoxctqmtdeocxrgvgtdigkeavhccelupgdnepkdhqnresmqbrpcgmahssidsomxswjoranmqojstnmnuijqmcmhemiwddfiqvqesgmfowasbvivolapsbwmxdadgcwjinbopieqqispmvrjhrvwiqxwdapsdtijuttmpopuhsicvlfxxchfwaggptwlsasakcxgmjvrdpbttpgivpwmtilkntdxkwefkaeemruguvnkasuvkisdabpltbiunqpcgfsoqvwvsnfqsmnmpuusnsrssunlbejwfkbuqgsveoalcmthbmdccnknsvqfxcnjoxcputbpdiovqdoedppbxxqwkelqxdqmcluntvrbpnammienuobqlcnuuiogqhefrxipxuueidncnmhrljaihoaookhgmvindcugoxcioknwngwhrpnxdckobbaprgemhfsabokfbdjqkhcboaoxhxctvgqdarjdphkhqcmeqnipfxcokwfwdvqvsqarjpoqjjksktatmscfgvwgeorwwleehqhbupdvokuqjahufxxjusprwltokjpiovvticjqomxttsqnloqljvthgscvnqibnichxxptammsbrtqfxultpuinwwniiixfbhfhqvfgmcftuauvcestxsvdfintqglgxtvbsuvgmbealqjrwpwbgmeixxffbslhtpqexdvjejxcptgctfaflkgdwlnqduikubmsxcmpsdwpahfqsgawpuufhenseflntmkrrbsabgbafgvkldhnkdewutwuxmcrxntlojxlxdanhxokftlslgqovpogsjpojgvggbtbnblgftiwjwwntnwfkiopgvalaocdqkwscitkiilhgvgwbjadcxwbkxhcwvajmlqwgqglqiafnhnfwjvhvthsxhtbadrsemkndcopmdvafecrkfukefhteflribmevvkpwnbxuidhpffdmnpmxlauksbsgpbqkxrdcbbtrxlddinlekvvfxqviwuubtagabakvxmstalniambdtguxqjnhpuwkpqwkdfmpwugrevtwkbfbbklmpknxpjsrcdhwgsjjgqvmkxfxiuwfdbifttnpnlofvjcmrnbthaauklfqrnnijlmrutvirldooiqfmqdmkthivqjmousjdbprluvjmhbnarwrqcqfolrarnkbnsfrcjqfwvntfixsiuhpllifexifjeapafwqferuiwufvgxearsqqtlndpsxkudpxomvmtahoqlqcchexjwlmbrnluivgnlbigraqegncbkdgkqsncmbbxjueukauxpegtdsijdxtkbhjqkvlgesonfcxiihnsrjwxlluahurtaejdfnitonujdrlardhwxpriqdvdbnfvorisqtutscbeeoavpentshiieasrdbwguxfxmpinhsxwhtpfijusbilonvdrdrmpkvbrjalihfoxgahsncojwdabmibvknqbautqphfgasnihfisoqcrpqrdjrtuiebloelewdowlkupujtxcladfgndujjoexheuukngfhapudwlexadcbvivvbvqddiftwbmotgexeorltupmuhgmripivdnctcxeaovkwhjpcortajctnhpbwvrwppjfglfksdhtojeocaldmiedsdurlgoppctfndowmqbdtummmmilolwelcflcemmgrmqobkwgumrfasrachmiihoagdhspdekpuqsxsfijxvfmfghcrvjaisbfwndhmhmlkvslwqsflajjochtvxbcrhwifgvepgfepfmonjurabdpefkgmriqbgpxrjanladlsscqihwnvabwiaodfloiaffcbhetjwaadekrwciadwvokcvkjfltpxgawpboiosdujgailturknoblvlaqhbojttijhgrsltllvhwrfpautpvmqnrdlcmfvrgfhtdjssargepuicxvocievbvxnncsklqehuxuogumtadfsfhdwehduplkguaiubxnatnkjqhlllelvaprdinkexuwhffxkklqdgmlkhiowehohkaunvihpbpdojrqlitggwnirfxgenhxsuswesifunnpnavljrqwtlxhorwbvmsvvouoaiwblkwmkjjotosiiuttrscjbciqiihvjhknurrcpgedjxqnxtarkbowrhsbtcsbxhliicwhlfhjdtcexgxlsgqplkhgomgedijcfvpnwhrjrebfqghahqqmqfbkjnkodjgmmbjlqmlkdavqslbqcrxfbonseghvithnoqpcruemjqnonmvmepvduwwqpxeltgxnbqhrrgfxlesgrtcdldrvdnrdcqsiscenxcbaatgurmdrwwbnrnudutjdorrkphgmggopomgcmxbgegrlmnvwrxerbjqtbuocidwhtoojkhuntllmwsvvjtkuejadileqdtaxxmfcnklwdfgavwdadvuuabqqtspnrmuxcnemdbosnltqlhaxbokklbrmusibbxmqfikxgeoqpwklxomtkftnhrdwkkgvdmgrgoaumcdachcjjdgloeindjfhfekqhdklphwspfulpdmkbfxafbadwapofwekntrugdtrolkaffppxoobxoeocpstcjllvokwfsikjnnxdmmhleuoubdggowoefhmhcgaddmmplujlhclvaqpvkwlcnkamkbetqftphaxkmpnmhkbfslnqdfgglxqairmbagwtgllbsptgeldmkupodpgcsmgjwgcsjcbgqgjutmtigorahunijfuwicdqfrqmeqnafqiuangendckktamowpcwjgtfjwqkbarnkjxjltjqbwdtaxestxouapmwhkpjvfbpukoondxjrvjcesonledrixbqtopsdrievvroevhgkqghosuwxhhhinmkeccudgoeocjdijxpfvrchgfoohleabuwdexrwdmhwxmdahqgjhrkowqwkmarsmrkpwgxeaqugwepuikkxtaaulxuqxnwmnkhbpwpewdnnpxxndwkxtfejdbakpblwmrmqqrbpuwieapklikhaoagubgeiewxjrvtnignnspwddtcnqqjtvbwgcwobptdfngcpxnsfbipracfmcoqphitwqbhwxpxbhvlxvwrpiicwfguawgtnevwnciqhuulnqaefdrtehwreeoxanpeueaxsjrwdojhtgqfqiggmpmkiecnegijvqrwotnmkgodrevajngcgxjwfwcqfbdlaxjtbkuinltgxpilhqhjthnnrqowtwhseswncgpemoijgjxalesbkpqguvgivgefbpjorfewgonefrevmwiluqcdhckoeikoiatexrnpettpfpnsdahxardkkjdqxnjdjfcimkawfvikoumrxrjfpttuurxnhurvtuqrpgxncvfmhpprcbfnrnsroshhmvdmxhubrxrklktgbqajbicwvpabhvmunifavfvokmowxuiidpwcwpcsebgmirmfcgqaepvbjwfjomwkwvjmboexfecraobkugngemtcwuidsjdmkrjxrdqgbhfbivkctisqwmhrkwgmitbwwewcpagwhcamqfopofjpcarwvuhtttxpsvqplegbigjcxoxhguisxgbiohljrquipehueiqfucstnretdfrlgrxrgwlgkssjfblcksulcocomuvdejkiwwlhesvkxrqclnuqwvslllburcsgjhvtqhvsbcsnqoockptiqgcnoagvxitwdxrcedouvwswuqudbxoqxpmrmfljuiajkcovjkmepgwxtiktjwgsuhrwushaibjqnoegpfqbpluoxnrdslmuxwhfpikbelwlvwlexltuhegefpxddhwhhviwuguoqppcjptwrulnujkqiovkvigkelkbmvfvdmfuktmnmbcejdsugllcpadhhqpopdohfdgthrgjrjhiminwxvcrrgmeqnwmetnlasuvkjsbaertftdhueianltcobgmesttktvlaewxqlcdnjdpfjhprgxrsmroosafdodvlrljjnbrduhgjlngfpajdwgklkfsubekdakqmkwvjlwmbsmmsoorsanaksqcugsehsjmjkjgmpiiuxlkqeblgbwqetdfnemjawknposgwhfttrsqgarfasbjrmftemcsweulxvblxtofvqiwmtwqqsominntdftxpngviqggxtrwlupeuebufbvjjgnpkpbpgismlgbpfqpgnwosddqaqhxafquvrldmjfpqaxkfbrqekfvhmauwansqulcvwxjujfvbotkceonbdcfenmwmosxdovhjunmavgmxvdhmwquwheubwoulbohprqlibnciolerxotuoohqptdgaoitscqvidobnoeetbvabmmkfiekchcllfitrnuvjpqncqktncxnoguwkpndjrshgcwfvxbgmsbmvlfptfkvltbhwcrkeajdsfjhwbrktorojadoocwdtlnhirqicmaxwgasoktptdrklgorwkegegxmjnrntwatlgvokcxgphhkwnmakmcnwvxhjewrifipbvxdfjmhuvmuigpclqsbcqfaprourrpdprgqfqmkfkjrbqojihskinjodjjfnlhgnucpkpwwqhvjclilsiuaxwdlhohfncxbmftonukfvfhllhxradwcastnqxrubwpmuekgorjfferjtnctljkssbbfjencqxxhmsfxuvrpacsjtvrqtbxwomfdqgmhcwxrvwnixqldnjbuknesxlfxmkhhfuwkakpmwbstrthanqakjxdpqimvtmiqbxemcuxwabnoxvoaxagdqsgqnxmxdaohefenxsxatamcuwormadgoofvhifxgatnnqifahxkgobxghbmmipmlerondpdjefhfawumqhljbtuvxfroisnadqkarcehswitlacupanodbtkgepcrnjnmllpbgcfmepqdfgalawktvkfneqrswibntxttlnwkbdlpfrherpicosvlxstmgsnigxmakuqkevvaqtktbaohmltauoxvgobvgtrxbjlofvgvveixkrmcpnofdugpevuscktbrkanetfootjisjtuhipjeuqscxorjorulihirhtdckpplrltudgmxnluwuijnfukocpoeihvkpqkmkdcoxcwmqchsuktfqtsjkrxfxklmluenbdonmlatgtleglojhhngwnluelgbwmcwrnrbscjunpwgdesbcacmqjtbhdfjiqwxjockapkhvvkhlepfavjkoqgeibqvihxaijrjajjnawgpougvshlsiqmgoxxthrgjpmxmariuurdouegranhdqcgflktmfajswhdnbghvcpqmmtqbcqffmvdcfudrkbldvlnctrmrchnrqbtvapfiorlwffhjwhrnmagngsbxuccnohhwclqfuihisuitqivokvvnrqgoqqqapvmsplnchawpokejkmgxqdkrvmbqnaoctkdlainqwbivxxwccuujhrgtsnumnluurxthvsgpdugbgclgriqcuipsamwbgqtmcueigisqeqptdtnmhhjmkhaoxiqjrqcmhpxuktbrspdkgddgdcpoixgxhcjdnsbcgddnlsrevgkahcodpichfqtfprjhmprahoakpouhvpnufxnejslrcbgiqoafexrmujotpgcecktpkdqhshsthdqqcbpfgbraldoxldrklpnhefxnkavnevxvfjfqkvclgfxidvlqrnkvlwdgqvgxqqvijptuivdnlgsnwtpaumkbrgtdovmbntcpncpsigmnthogvggjunnevmxscrqtjxulkddcjdgnvpleqvptbamuoiiuniifvunnqbhfucpmdpjfpjkwkuosfmvchlgxrjfepnsjbtckthjkcrxsaclxsfotirssugcpholaapuiogsljgpxtbusnomoptluinwixwnbboxmmfublxjolcikvewnorrotljwrcntlpshndqcjfwfqmxbmsuhtsejwdbqlunixtvjqbnqdqevrqcgagpehgvljdqqoenpwbbtxodjjpfxaoxakavtcgdgmtfnrbdivcvlqtlhstbrlvbrsbbwdsojgmbpwmrdhnrlmiujidoflnnahbaemjglawlotvoqdtgrlegojqojiivftpmodmugtadcjttpillheacaojbhbdiqemmsjlijmsrligoihpitbdxwphvvijpsdiqbwfaugwgsixjdaewxqofausentaarqrjdjkwhijbfbguileuskquwmjvwdafwskojmljcbokvcsoihpsmpcfqinjaakoblbqrfacvktsluuprweafplhganhtbortbxfmfipalqqnhmxuoepfjmdqmchpalikvlhtemsmuguvdjhkqpgehnpputrutcdaxfovsutxvnhratgbeegspfwrirwslcithpibwobkvualndudblopcnnhhtfjiujnuxxjknmofehsubchboodhegcscxkcpgninkumxmjwmvwlmpuccoxqlaabosdauftjkcsffcfvfrwdnlunrhjtjtdewavldqwaggtmofangdultooctidbxxsslrrutwinqwwtlnuvidpvxbkjqrtsfnmvelfreiqhakwqtsautchxqlqbxdlgcfdlsqtsinoialafxndlopfkpvqmqvrfovonuqsrufswfafawgpssthoeocqexpwtxvllbretqvcckncbttbguodwooodsucwsifhfsudxnenxaciwhhdvsrwvvguuacsppcxtujerlegspkkwtoatmhdmnxaislvfsteextxgxjoiqipdpmoakogkhdodmaxujqvhlsuhkundfvrgecftwxgpmiphnarumrlmqnclcwscurngiaeuoheukhldnslotgvlwwckjmwfxugmenlmmjaitqjqfpmjxhmffllvvjaeuvkoqtmbwmbdfsjetpnvodpbnvwlaerqnfjpnqmwoxpocxubicndcdhiodkejeabbvemrnoqlteqrfkhmpnsrpeajpibxkwnqttgwchbnivjkfcnqiekvxnmexirmwtgcxfocxcaeonbnhfdcldmmcljjmbmhigdpttuptfgqmsbrdkbmbshasnrowmkaiavpfugehicbleaaikimcitifmcnniehnqtchbobefuhmepspvpevfrumxhuaobeqxvqhbtnpjmsvcvvbcwlmtadxxffrnsxbetbvvwclxlcwnccesnanxahgeohgogbqqovdngxxuiqjnwjaunnbmjhivcsianinsnvaadusdtsuuksxjnrqqmlwlhohmpvxtqxtxfknsfrrxvwhiwebdqmifpstcvjqtafnjvpqrnoobxdkcxowwgaouritjgcwjefgxsulrthlijtowihnbuaihgiassckomjfivjocqgcusednrhxlemghuqcmshlbjpefmhaldscwsqtpdoemwfpdvbjafttlkjjojmcvuccwcgmlvfeoabumbtvvtviuxwvcejfhuqtljvisakpxusnsxpnufmekroiblxgkcdfgxpvlcgehkokmhdtnbcfigbsmqnafgtigvdepfcepapcdrqfhkgtmbxdddkkbaalmkjmnjmxgaupgwhetfqqp")
        );
        System.out.println(
            firstUniqChar("loveleetcode")
        );
    }

}
