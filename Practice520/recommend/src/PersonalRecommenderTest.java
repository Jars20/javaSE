
import java.util.Arrays;
import java.util.TreeSet;
import org.junit.Assert;

public class PersonalRecommenderTest {

    @org.junit.Test
    public void recommendTest() {
        PersonalRecommender personalRecommendor = new PersonalRecommender();
        personalRecommendor.addLikes("张三", "java");
        personalRecommendor.addLikes("张三", "c++");
        personalRecommendor.addLikes("张三", "php");
        personalRecommendor.addLikes("李四", "python");
        personalRecommendor.addLikes("李四", "golang");
        personalRecommendor.addLikes("李四", "php");
        personalRecommendor.addLikes("王五", "c#");
        personalRecommendor.addLikes("王五", "php");
        personalRecommendor.addLikes("王五", "pascal");
        try {
            Assert.assertTrue(personalRecommendor.likesBoth("张三", "java", "c++"));
            Assert.assertEquals(Arrays.asList("python", "golang", "php"),
                    personalRecommendor.recommendByPerson("李四"));

            Assert.assertArrayEquals(
                    new TreeSet<>(Arrays.asList("java", "c++", "python", "golang", "c#", "pascal")).toArray(),
                    new TreeSet<>(personalRecommendor.recommendByProject("php")).toArray());

            Assert.assertTrue(
                    Arrays.asList("java", "c++", "python", "golang", "c#", "pascal")
                            .containsAll(personalRecommendor.recommendByProject("php")));
            personalRecommendor.likesBoth("赵六", "", "");
            Assert.fail();
        } catch (UnknownPersonException e) {
            e.printStackTrace();
        }
    }
}