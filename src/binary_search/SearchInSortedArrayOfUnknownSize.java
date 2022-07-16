package binary_search;

public class SearchInSortedArrayOfUnknownSize {
    public int search(ArrayReader reader, int target) {
        int left=0, right=1;
        while(reader.get(right)<target) {
            left=right;
            right=right<<2;
        }

        while(left<=right) {
            int mid=left+(right-left)/2;
            if(reader.get(mid)==target) {
                return mid;
            } else if(reader.get(mid)>target) {
                right=mid-1;
            } else {
                left=mid+1;
            }
        }

        return -1;
    }
}

interface ArrayReader {
    public int get(int index);
}
