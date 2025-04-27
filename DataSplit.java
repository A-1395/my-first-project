public class DataSplit {



    //

    // O(log(Math.min(100-parcentage)/size of data ,parcentage));
    // o(n)
    public static List<Integer>[] splitDataSet(@NotNull List<Integer> dataset, double percentage){
        List<Integer> shuffled = new ArrayList<>(dataset);
        int size = dataset.size();

        boolean[] infirstSet = new boolean[size];
        int firstSetSize = (int)(size * percentage/100);
        Random random = new Random();
        int selected=0;
        while(selected < firstSetSize){
            int index= random.nextInt(size);
            if(!infirstSet[index]){
                infirstSet[index]=true;
                selected++;
            }
        }

        List<Integer> firstSet = new ArrayList<>(firstSetSize);
        List<Integer> secondSet = new ArrayList<>(size -firstSetSize);

        for(int i =0;i<size;i++){
            if(infirstSet[i]){
                firstSet.add(dataset.get(i));
            }else{
                secondSet.add(dataset.get(i));
            }
        }


        return new List[]{firstSet,secondSet};

    }


    // testcases

}
