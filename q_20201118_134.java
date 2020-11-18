class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
			// 记录当前总共加了多少油以及消费的总油量
            int sumOfGas = 0, sumOfCost = 0;
			// 计数器，计算当前是否形成圈
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
				// 如果消费超过总油量直接break，从i + cnt + 1继续循环。
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
				// 避免不必要的计算
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
