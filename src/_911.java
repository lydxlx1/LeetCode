/**
 * LeetCode 911 - Online Election
 *
 * Binary Search
 * Pre-processing is actually pretty simple and does not need any complex data structure because if the top candidate
 * will change, he/she can only change to the current person.
 */
public class _911 {

    int[] topCandidate;
    int[] times;

    public _911(int[] persons, int[] times) {
        this.times = times;
        topCandidate = new int[times.length];

        int[] hits = new int[5555];
        int cand = persons[0];
        hits[cand]++;
        topCandidate[0] = cand;
        for (int i = 1; i < times.length; i++) {
            hits[persons[i]]++;
            if (hits[persons[i]] >= hits[cand]) {
                cand = persons[i];
            }
            topCandidate[i] = cand;
        }
    }

    public int q(int t) {
        int left = 0, right = times.length;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (t >= times[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return topCandidate[left];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */