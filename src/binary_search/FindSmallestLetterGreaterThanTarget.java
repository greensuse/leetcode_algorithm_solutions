package binary_search;

public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters={'c','f','j'};
        char answer = new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(letters, 'j');
        System.out.println(answer);
    }
    public char nextGreatestLetter(char[] letters, char target) {
        int left=0, right=letters.length;

        while(left<right) {
            int mid=left+(right-left)/2;
            if(letters[mid]<=target) {
                left=mid+1;
            } else {
                right=mid;
            }
        }

        return letters[left%letters.length];
    }
}
