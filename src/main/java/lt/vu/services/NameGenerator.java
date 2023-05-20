package lt.vu.services;

import lt.vu.interceptors.LoggedInvocation;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;
import javax.enterprise.inject.Alternative;

@Alternative
@ApplicationScoped
public class NameGenerator implements Serializable, INameGenerator {

    private static final String[] WORDS = {
            "lorem", "ipsum", "dolor", "sit", "amet", "consectetur",
            "adipiscing", "elit", "curabitur", "vel", "hendrerit", "libero"
    };

    private static final Random RANDOM = new Random();

    private static String generateSentence() {
        StringBuilder sentence = new StringBuilder();
        int sentenceLength = 3;
        for (int i = 0; i < sentenceLength; i++) {
            if (i > 0) {
                sentence.append(" ");
            }
            sentence.append(WORDS[RANDOM.nextInt(WORDS.length)]);
        }
        return sentence.toString();
    }

    @Override
    public String generateName(){
        try{
            Thread.sleep(5000);
        }
        catch (InterruptedException e){

        }
        return generateSentence();
    }
}
