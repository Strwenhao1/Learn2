package com.bjsxt.map;

public class HashMap implements Map {
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    transient int size;

    transient Entry[] table;

    public HashMap() {
        table = new Entry[DEFAULT_INITIAL_CAPACITY];

    }

    @Override
    public void put(Object key, Object value) {
        int hash = key.hashCode();

        int index = hash%table.length;

        if(table[index] == null){
            Entry entry = new Entry(key,value , null,hash);
            table[index] = entry;
            size++;
        } else {
            Entry entry = table[index];
            while (entry != null){

                if(entry.hash==hash&&entry.key.equals(key)){
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            Entry firstEntry = table[index];
            table[index] = new Entry(key,value , firstEntry,hash);
            size++;
        }

    }

    @Override
    public Object get(Object key) {
        //计算哈希码
        int hash = key.hashCode();
        //根据哈希码计算存储位置
        int index = hash % table.length;
        //查找对应的Entry
        Entry entry = null;
        if (table[index] != null) {
            Entry currentEntry = table[index];
            while (currentEntry != null) {
                if (currentEntry.getKey().equals(key)) {
                    entry = currentEntry;
                    break;
                }
                currentEntry = currentEntry.next;
            }
//            return  table[index].getValue();
        }
        return entry == null ? null : entry.getValue();
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }



    class Entry implements Map.Entry{

        final Object key;
        int hash;
        Object value;
        Entry next;


        public Entry(Object key,Object value,  Entry next, int hash) {
            this.key = key;
            this.hash = hash;
            this.value = value;
            this.next = next;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", hash=" + hash +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder("{");
      for (int i = 0 ; i < table.length ; i++){
          if (table[i] != null){
              Entry entry = table[i];

              while (entry != null){
                  builder.append(entry.getKey()+"="+entry.getValue()+",");
                  entry = entry.next;
              }
          }
      }
      if(size != 0){
          builder.deleteCharAt(builder.length()-1);
      }

      builder.append("}");

      return builder.toString();
    }
}
