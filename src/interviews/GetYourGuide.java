package interviews;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GetYourGuide {

    public static void main(String[] args) {
        String str = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "john.png, London, 2015-06-20 15:13:22\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11";

        System.out.println(solution(str));
    }

    public static String solution(String S) {
        StringBuilder result = new StringBuilder();
        Map<String, List<Photo>> photosMap = new HashMap<>();
        String[] photos = S.split(System.lineSeparator());
        for (String photo : photos) {
            String[] record = photo.split(",");
            String key = record[1];
            String strDate = record[2];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(strDate, formatter);
            if (photosMap.containsKey(key)) {
                photosMap.get(key).add(new Photo(record[0], record[1], dateTime));
            } else {
                List<Photo> list = new ArrayList<>();
                list.add(new Photo(record[0], record[1], dateTime));
                photosMap.put(key, list);
            }
        }

        for (String city : photosMap.keySet()) {
            List<Photo> cityList = photosMap.get(city);
            cityList.sort(Comparator.comparing(Photo::getTakenTime));
            int paddingSize = 0;
            int size = cityList.size();
            while (size > 0) {
                size = size / 10;
                paddingSize++;
            }
            for (int i = 0; i < cityList.size(); i++) {
                String extension = cityList.get(i).getName().split("\\.")[1];
                String name = (city + String.format("%0" + paddingSize + "d", i + 1) + "." + extension).trim();
                cityList.get(i).setName(name);
            }
        }

        for (String photo : S.split(System.lineSeparator())) {
            String[] record = photo.split(",");
            String city = record[1];
            String strDate = record[2];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(strDate, formatter);

            List<Photo> cityPhotos = photosMap.get(city);
            Optional<Photo> p = cityPhotos.stream().filter(photo1 -> photo1.getTakenTime().equals(dateTime)).findFirst();
            if (p.isPresent()) {
                result.append(p.get().name).append("\n");
            }
        }

        return result.toString();
    }


    private static class Photo {
        String name;
        String city;
        LocalDateTime takenTime;

        public Photo(String name, String city, LocalDateTime takenTime) {
            this.name = name;
            this.city = city;
            this.takenTime = takenTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public LocalDateTime getTakenTime() {
            return takenTime;
        }

        public void setTakenTime(LocalDateTime takenTime) {
            this.takenTime = takenTime;
        }
    }
}
