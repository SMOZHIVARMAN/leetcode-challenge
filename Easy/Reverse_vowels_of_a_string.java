class Solution {
    public String reverseVowels(String s) {
        char[] sarray = s.toCharArray();
        int i=0;
        int j=sarray.length-1;

        while(i<j){

            while(i<j && !isVovel(sarray[i])){
                i++;
            }

            while(i<j && !isVovel(sarray[j])){
                j--;
            }

            char temp= sarray[i];
            sarray[i]=sarray[j];
            sarray[j]=temp;
            i++;
            j--;
        }
       return new String(sarray);

       
    }
    boolean isVovel(char c){
        return "aeiouAEIOU".indexOf(c)!=-1;
    }
}