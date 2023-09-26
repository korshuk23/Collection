package com.core.collection.practice;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionsTasks {
    /**
     * Написать метод, который принимает на вход список и возвращает новый список,
     * содержащий только уникальные элементы первого списка.
     */
    public static <T> List<T> uniqueList(List<T> list) {
        Set<T> unique = new HashSet<>(list);
        return unique.stream().toList();
    }

    /**
     * Написать метод, который принимает на вход список и возвращает новый список,
     * содержащий только элементы, длина которых больше 5.
     */
    public static List<String> largeElements(List<String> list) {
        return list.stream().filter(s -> s.length() > 5).toList();
    }

    /**
     * Написать метод, который принимает на вход два списка и возвращает новый список,
     * содержащий элементы, которые встречаются в обоих списках.
     */
    public static <T> List<T> retain(List<T> list1, List<T> list2) {
        List<T> resList = new ArrayList<>(list1);
        resList.retainAll(list2);
        return resList;
    }

    /**
     * Написать метод, который принимает на вход список строк и возвращает новый список,
     * содержащий элементы, отсортированные по возрастанию длины строки.
     */
    public static List<String> sortByAscendingOrder(List<String> list) {
        List<String> resList = new ArrayList<>(list);
        resList.sort(Comparator.comparing(String::length));
        return resList;
    }

    /**
     * Написать метод, который принимает на вход список объектов и возвращает новый список,
     * содержащий только объекты, которые являются экземплярами определенного класса.
     */
    public static <T> List<T> listInstanceOf(List<T> list, Class<?> targetClass) {
        return new ArrayList<>(list).stream().
                filter(targetClass::isInstance).
                toList();
    }

    /**
     * Написать метод, который принимает на вход список и возвращает новый список,
     * содержащий только те элементы, которые встречаются в исходном списке не менее двух раз.
     */
    public static <T> List<T> listOfRepeated(List<T> list) {
        Map<T, Integer> mapWithCounter = new HashMap<>();
        for (T t : list) {
            mapWithCounter.put(t, mapWithCounter.getOrDefault(t, 0) + 1);
        }
        List<T> resList = new ArrayList<>();
        for (Map.Entry<T, Integer> entry : mapWithCounter.entrySet()) {
            if (entry.getValue() > 2) {
                resList.add(entry.getKey());
            }
        }
        return resList;
    }

    /**
     * Написать метод, который принимает на вход список и возвращает новый список,
     * содержащий только элементы, которые содержат в себе определенную подстроку.
     */
    public static List<String> listSublist(List<String> list, String substring) {
        return new ArrayList<>(list).stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    /**
     * Написать метод, который принимает на вход очередь и возвращает ее копию, сохраняя порядок элементов.
     */
    public static <T> List<T> listCopy(Queue<T> list) {
        return new LinkedList<>(list);
    }

    /**
     * Написать метод, который принимает на вход две очереди и возвращает новую очередь,
     * содержащую элементы из обоих очередей, сохраняя порядок элементов.
     */
    public static <T> Queue<T> combinedQueue(Queue<T> queue1, Queue<T> queue2) {
        Queue<T> queue = new LinkedList<>(queue1);
        queue.addAll(queue2);
        return queue;
    }

    /**
     * Написать метод, который принимает на вход список объектов и возвращает новый список,
     * содержащий только объекты, которые удовлетворяют определенному условию, заданному
     * в виде функционального интерфейса.
     */
    public static <T> List<T> updateList(List<T> list, Predicate<T> condition) {
        return new ArrayList<>(list).stream()
                .filter(condition).toList();
    }

    /**
     * Написать метод, который принимает на вход список объектов и возвращает новый список,
     * содержащий элементы, которые были преобразованы с помощью функционального интерфейса.
     */
    public static <T> List<T> updateList2(List<T> list, Comparator<T> listComparator) {
        List<T> resList = new ArrayList<>(list);
        resList.sort(listComparator);
        return list;
    }

    /**
     * Написать метод, который принимает на вход двустороннюю очередь и возвращает ее копию,
     * сохраняя порядок элементов.
     */
    public static <T> Deque<T> copyDeque(Deque<T> deque) {
        return new LinkedList<>(deque);
    }

    /**
     * Написать метод, который принимает на вход очередь и возвращает новую очередь,
     * содержащую только элементы, которые были добавлены в нее ранее, чем другие элементы.
     */
    public static <T> Deque<T> addBefore(Deque<T> queue) {
        Deque<T> resQueue = new ArrayDeque<>();
        Deque<T> copyQueue = new ArrayDeque<>(queue);
        while (!copyQueue.isEmpty()) {
            T currentElement = copyQueue.removeLast();
            if (!copyQueue.contains(currentElement)) {
                resQueue.addFirst(currentElement);
            }
        }
        return resQueue;
    }

    /**
     * Написать метод, который принимает на вход двустороннюю очередь
     * и возвращает новую очередь, содержащую элементы в обратном порядке.
     */
    public static <T> Deque<T> reversedDeque(Deque<T> deque) {
        Deque<T> reversedQueue = new LinkedList<>();
        for (T item : deque) {
            reversedQueue.addFirst(item);
        }
        return reversedQueue;
    }

    /**
     * Написать метод, который принимает на вход два списка и возвращает новый список,
     * содержащий элементы, которые присутствуют только в одном из списков, но не
     * встречаются в обоих списках.
     */
    public static <T> List<T> uniqueElementsFilter(List<T> list1, List<T> list2) {
        List<T> resList = new ArrayList<>(list1);
        resList.removeAll(list2);
        return resList;
    }

    /**
     * Написать метод, который принимает на вход карту и возвращает ее копию,
     * сохраняя порядок элементов.
     */
    public static <K, V> Map<K, V> copyMap(Map<K, V> map) {
        return new LinkedHashMap<>(map);
    }

    /**
     * Написать метод, который принимает на вход две карты и возвращает новую карту,
     * содержащую элементы из обоих карт, сохраняя порядок элементов.
     */
    public static <K, V> Map<K, V> mergeMapsWithOrder(Map<K, V> map1, Map<K, V> map2) {
        Map<K, V> resMap = new LinkedHashMap<>(map1);
        resMap.putAll(map2);
        return resMap;
    }

    /**
     * Написать метод, который принимает на вход карту и возвращает ключ первого
     * вхождения заданного значения.
     */
    public static <K, V> K getFirstKey(Map<K, V> map, int value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (Objects.equals(entry.getValue(), value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Написать метод, который принимает на вход карту и возвращает значение первого
     * вхождения заданного ключа.
     */
    public static <K, V> V getFirstValue(Map<K, V> map, int key) {
        return map.get(key);
    }

    /**
     * Написать метод, который принимает на вход карту и возвращает новую карту,
     * в которой ключи и значения поменяны местами.
     */
    public static <K,V> Map<V, K> swapKeyWithValue(Map<K, V> map) {
        HashMap<V,K> resMap = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            resMap.put(entry.getValue(), entry.getKey());
        }
        return resMap;
    }

    /**
     * Написать метод, который принимает на вход две карты и возвращает новую карту,
     * содержащую ключи и значения из обеих карт, где конфликтующие ключи суммируются.
     */
    public static <V> Map<Integer, V> mergeMapsWithCollisionChecks(Map<Integer, V> map1, Map<Integer, V> map2) {
        Map<Integer, V> resMap = new HashMap<>(map1);
        for (Map.Entry<Integer, V> entry : map2.entrySet()) {
            Integer key = entry.getKey();
            V value = entry.getValue();
            if (resMap.containsKey(key)) {
                resMap.put(key + key, value);
            } else {
                resMap.put(key, value);
            }
        }
        return resMap;
    }

    /**
     * Написать метод, который принимает на вход карту и возвращает новую карту,
     * содержащую только элементы, у которых ключ начинается с заданной подстроки.
     */
    public static <V> Map<String, V> keyFilter(Map<String, V> map, String substring) {
        Map<String, V> resMap = new HashMap<>(map);
        for (Map.Entry<String, V> entry : map.entrySet()) {
            if (entry.getKey().startsWith(substring)) {
                resMap.put(entry.getKey(), entry.getValue());
            }
        }
        return resMap;
    }

    /**
     * Написать метод, который принимает на вход карту и возвращает новую карту,
     * содержащую только элементы, у которых значение является экземпляром определенного класса.
     */
    public static <K, V> Map<K, V> valueFilter(Map<K, V> map, Class<?> targetClass) {
        Map<K, V> resMap = new HashMap<>(map);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (targetClass.isInstance(entry.getValue())) {
                resMap.put(entry.getKey(), entry.getValue());
            }
        }
        return resMap;
    }

    /**
     * Написать метод, который принимает на вход карту и возвращает новую карту,
     * содержащую только элементы, у которых значение больше заданного значения.
     */
    public static <K> Map<K, Integer> valueFilter2(Map<K, Integer> map, int value) {
        Map<K, Integer> resMap = new HashMap<>();
        for (Map.Entry<K, Integer> entry : map.entrySet()) {
            if (entry.getValue() > value) {
                resMap.put(entry.getKey(), entry.getValue());
            }
        }
        return resMap;
    }

    /**
     * Написать метод, который принимает на вход карту и возвращает новую карту,
     * содержащую элементы, ключи которых являются экземплярами определенного класса
     * и значения которых начинаются с определенной подстроки.
     */
    public static <K> Map<K, String> filterKeyValue(Map<K, String> map, Class<?> targetClass, String prefix) {
        Map<K, String> resMap = new HashMap<>();
        for (Map.Entry<K, String> entry : map.entrySet()) {
            if (targetClass.isInstance(entry.getKey()) && entry.getValue().startsWith(prefix)) {
                resMap.put(entry.getKey(), entry.getValue());
            }
        }
        return resMap;
    }

    /**
     * Написать метод, который принимает на вход список и возвращает новый список,
     * содержащий элементы в обратном порядке.
     */
    public static <T> List<T> reverseList(List<T> list) {
        LinkedList<T> list2 = new LinkedList<>();
        for (T t : list) {
            list2.addFirst(t);
        }
        return list2;
    }

    /**
     * Написать метод, который принимает на вход список и возвращает новый список,
     * содержащий элементы в порядке убывания их количества в исходном списке.
     */
    public static <T> List<T> sortByFrequency(List<T> inputList) {
        Map<T, Integer> frequencyMap = new HashMap<>();
        for (T element : inputList) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }
        return inputList.stream()
                .distinct()
                .sorted(Comparator.comparingInt(frequencyMap::get).reversed())
                .collect(Collectors.toList());
    }

    /**
     * Написать метод, который принимает на вход множество и возвращает его копию,
     * сохраняя порядок элементов.
     */
    public static <T> Set<T> copySetWithOrder(Set<T> originalSet) {
        return new LinkedHashSet<>(originalSet);
    }

    /**
     * Написать метод, который принимает на вход два множества и возвращает новое множество,
     * содержащее элементы из обоих множеств, сохраняя порядок элементов.
     */
    public static <T> Set<T> mergeSetsWithOrder(Set<T> set1, Set<T> set2) {
        Set<T> mergedSet = new LinkedHashSet<>(set1);
        mergedSet.addAll(set2);
        return mergedSet;
    }

    /**
     * Написать метод, который принимает на вход множество и возвращает новое множество,
     * содержащее только элементы, у которых значение является экземпляром определенного класса.
     */
    public static <T> Set<T> filterElementsByClass(Set<T> set, Class<T> targetClass) {
        Set<T> filteredSet = new HashSet<>();
        for (T item : set) {
            if (targetClass.isInstance(item)) {
                filteredSet.add(item);
            }
        }
        return filteredSet;
    }

    /**
     * Написать метод, который принимает на вход множество и возвращает новое множество,
     * содержащее только элементы, у которых значение больше заданного значения.
     */
    public static <T extends Comparable<T>> Set<T> filterSetElement(Set<T> originalSet, T thresholdValue) {
        Set<T> filteredSet = new HashSet<>();
        for (T item : originalSet) {
            if (item.compareTo(thresholdValue) > 0) {
                filteredSet.add(item);
            }
        }
        return filteredSet;
    }

    /**
     * Написать метод, который принимает на вход множество и возвращает новое множество,
     * содержащее элементы в порядке убывания их хэш-кодов.
     */
    public static <T> Set<T> descendingSortSetByHashCode(Set<T> set) {
        List<T> list = new ArrayList<>(set);
        list.sort(Comparator.comparingInt(Object::hashCode).reversed());
        return new LinkedHashSet<>(list);
    }
}

