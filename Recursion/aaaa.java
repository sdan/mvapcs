public class TestSample {

private ArrayList<Integer> samples;
public TestSample (int n) {
samples = new ArrayList<Integer>(); for(int k = 0; k < n; k++)
{
samples.add(k);
} }
public double getBestRatio ( ) {
} }
double maxRatio = samples.get(1).intValue() / samples.get(0).intValue();
for(int k = 1; k < samples.size() ‐ 1; k++) {
double ratio = samples.get(k+1).intValue() / samples.get(k).intValue(); if (ratio > maxRatio)
{
maxRatio = ratio; return maxRatio;
}
