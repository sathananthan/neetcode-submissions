class TimeMap {

    // Stores key -> list of timestamp/value pairs
    private Map<String, List<Entry>> map;

    // Stores timestamp and value together
    static class Entry {
        int timestamp;
        String value;

        Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    // Constructor
    public TimeMap() {
        map = new HashMap<>();
    }
    
    // Store value with timestamp
    public void set(String key, String value, int timestamp) {

        map.putIfAbsent(key, new ArrayList<>());

        map.get(key).add(new Entry(timestamp, value));
    }

    // Retrieve value using binary search
    public String get(String key, int timestamp) {

        if (!map.containsKey(key)) {
            return "";
        }

        List<Entry> list = map.get(key);

        int left = 0;
        int right = list.size() - 1;

        String result = "";

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (list.get(mid).timestamp <= timestamp) {

                result = list.get(mid).value;

                // Search for a later valid timestamp
                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return result;
    }
}
