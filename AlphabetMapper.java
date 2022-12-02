import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class AlphabetMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
  public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
    // Mapper 클래스에서 상속을 받는다. 첫번째 두번째는 Input, 세번째 네번째는 output
    String line = value.toString(); //문자열로
    //StringTokenizer tokenizer = new StringTokenizer(line); //단어 기준으로 분할하기
    String tokenizer[] = line.split("");
    // while (line.length()) {
    //   //Text outputKey = new Text(tokenizer.nextToken());
    //   output.collect(outputKey, new IntWritable(1));
    // }
    for(String SingleChar : tokenizer) {
        Text charKey = new Text(SingleChar);
        IntWritable One = new IntWritable(1);
        output.collect(charKey, One);
    }
  }
}
