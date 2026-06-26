class LFUCache {

    class Node {
        int key, val, freq;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            val = v;
            freq = 1;
        }
    }

    class DLL {
        Node head, tail;
        int size;

        DLL() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void add(Node node) {
            Node temp = head.next;
            node.next = temp;
            node.prev = head;
            head.next = node;
            temp.prev = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if(size > 0) {
                Node last = tail.prev;
                remove(last);
                return last;
            }
            return null;
        }
    }

    int capacity, minFreq;
    HashMap<Integer, Node> map;
    HashMap<Integer, DLL> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(capacity == 0) return;

        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            update(node);
        } else {

            if(map.size() == capacity) {
                DLL list = freqMap.get(minFreq);
                Node toRemove = list.removeLast();
                map.remove(toRemove.key);
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);

            minFreq = 1;
            DLL list = freqMap.getOrDefault(1, new DLL());
            list.add(newNode);
            freqMap.put(1, list);
        }
    }

    public void update(Node node) {
        int freq = node.freq;
        DLL list = freqMap.get(freq);

        list.remove(node);

        if(freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.freq++;

        DLL newList = freqMap.getOrDefault(node.freq, new DLL());
        newList.add(node);
        freqMap.put(node.freq, newList);
    }
}