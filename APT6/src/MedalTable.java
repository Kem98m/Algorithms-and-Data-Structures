import java.util.*;

public class MedalTable {
    public HashMap<String, MedalCountry> myMap;

    public class MedalCountry {
        int gold;
        int silver;
        int bronze;
        String name;

        public MedalCountry(String country) {
            name = country;
        }
        public int getGold() {
            return gold;
        }
        public int getSilver() {
            return silver;
        }
        public int getBronze() {
            return bronze;
        }
        public String getCountry() {
            return name;
        }
    }

    public String[] generate(String[] results) {

        HashMap<String, MedalCountry> map = new HashMap<>();
        for (String s : results) {
            String[] data = s.split(" ");
            for (int k = 0; k < 3; k++) {
                map.putIfAbsent(data[k], new MedalCountry(data[k]));
                if (k == 0) {
                    map.get(data[k]).gold += 1;
                }
                if (k == 1) {
                    map.get(data[k]).silver += 1;
                }
                if (k == 2) {
                    map.get(data[k]).bronze += 1;
                }
            }
        }
        myMap = map;
        ArrayList<String> list = new ArrayList<>(map.keySet());
        ArrayList<String> ret = new ArrayList<>();
        Collections.sort(list, new ListComp());
        for (String country : list) {
            int gold = map.get(country).getGold();
            int silver = map.get(country).getSilver();
            int bronze = map.get(country).getBronze();
            ret.add(country+" "+gold+" "+silver+" "+bronze);
        }
        return ret.toArray(new String[0]);
    }


    private class ListComp implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            if (myMap.get(a).gold < myMap.get(b).gold) {
                return 1;
            }
            if (myMap.get(a).gold > myMap.get(b).gold) {
                return -1;
            }
            if (myMap.get(a).silver < myMap.get(b).silver) {
                return 1;
            }
            if (myMap.get(a).silver > myMap.get(b).silver) {
                return -1;
            }
            if (myMap.get(a).bronze < myMap.get(b).bronze) {
                return 1;
            }
            if (myMap.get(a).bronze > myMap.get(b).bronze) {
                return -1;
            }
            int small = Math.min(a.length(), b.length());
            for (int k = 0; k<small; k++) {
                if (a.charAt(k) - b.charAt(k) < 0) {
                    return -1;
                }
                if (a.charAt(k) - b.charAt(k) > 0) {
                    return 1;
                }
            }
            return 0;
        }
    }
}