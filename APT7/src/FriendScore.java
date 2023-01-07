import java.util.*;

public class FriendScore {
    TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
    int maxfriends = 0;
    public int highestScore(String[] friends) {
        int counter = 0; //-1;
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < friends.length; i++) {
            //counter ++;
            //String[] indiv = str.split("");
            for (int k = 0; k < friends[i].length(); k++) {
                if (friends[i].charAt(k) == 'Y') {
//                    map.putIfAbsent(counter, 1);
                    set.add(k);
                    for (int j = 0; j < friends[k].length(); j++) {
                        if(friends[k].charAt(j) == 'Y' && j != i) {
                            set.add(j);
                        }
                    }
                }
            }
            //map.put(counter, set); //[1,3]
            if (set.size() > maxfriends) {
                counter = set.size();
                maxfriends = counter;
            }
            set.clear();
        }
//        for (Integer index : map.keySet()) {
//            int length = map.get(index).size();
//            for (int k = 0; k<length; k++) {
//                if (twoFriends(k).size() > maxfriends) {//I think the issue is around here
//                    maxfriends = twoFriends(k).size();
//                }
//            }
//        }

        return maxfriends;
    }

//    private Set<Integer> twoFriends(int index) {
//        Set<Integer> set = new TreeSet<>();
//        Set<Integer> friends = map.get(index);
//        set.addAll(friends);
//        for(int friend: friends) {
//            set.addAll(map.get(friend));
//        }
//        set.remove(index);
//        return set;
//    }
}