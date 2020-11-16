import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class q_20201116_406 {

    public int[][] reconstructQueue(int[][] people) {
        // 特殊情况判断
        if (0 == people.length || 0 == people[0].length){
            return new int[0][0];
		}
        // 对数据进行排序
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        // 对数据进行插空处理
        List<int[]> res = new ArrayList<>();
        for(int []pp: people){
            // 计数器，计算现在有几个比当前待插入元素高的元素个数。
            int count = 0;
            // 遍历整个已排序的数组
            for(int i = 0; i < res.size(); i ++){
                // 如果已经找到前面（左边）的高个，那么在当前位置落脚即可。不用管右边的，因为右边的比自己矮，在后面插入。
                if(count >= pp[1]){
                    res.add(i, pp);
                    count = -1;
                    break;
                }
                // 对应找高个的过程，找到高个计数器就加1。找到指定个数的高个
                if(res.get(i)[0] >= pp[0]){
                    ++count;
                }
            }
            // 如果当前插入值位于最右边（最矮），那么也要插入。
            if(count != -1){
                res.add(pp);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}