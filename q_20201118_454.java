class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> mapAB = list2Map(A, B);
        Map<Integer, Integer> mapCD = list2Map(C, D);
        int result = 0;
        for(Map.Entry<Integer, Integer> entryAB : mapAB.entrySet()){
            int keyAB = entryAB.getKey();
            int valueAB = entryAB.getValue();
            int res = mapCD.getOrDefault(-keyAB, 0);
             result = result + valueAB * res;
        }
        return result;
    }
    public Map<Integer, Integer> list2Map(int []arrayA, int[] arrayB){
        Map<Integer, Integer> map = new HashMap<>((int)(arrayA.length / 0.8)); // size应该初始化为 N / 0.75
        for(Integer valA : arrayA){
        	for(Integer valB : arrayB){
            	map.put(valA + valB, map.getOrDefault(valA + valB, 0) + 1);
        	}
        }
        return map;
    }
}