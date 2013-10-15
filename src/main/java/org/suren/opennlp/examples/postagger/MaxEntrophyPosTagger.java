package org.suren.opennlp.examples.postagger;

import java.io.File;
import java.io.FileInputStream;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.SimpleTokenizer;

public class MaxEntrophyPosTagger {
	public static void main(String a[]) {
		try {
			File posModelFile = new File("src/main/java/org/suren/opennlp/examples/postagger/en-pos-maxent.bin");
			FileInputStream posModelStream = new FileInputStream(posModelFile);
			POSModel model = new POSModel(posModelStream);
			POSTaggerME tagger = new POSTaggerME(model);
			String[] words = SimpleTokenizer.INSTANCE.tokenize("The quick, red fox jumped over the lazy, brown dogs.");
			String[] result = tagger.tag(words);
			for (int i = 0; i < words.length; i++) {
				System.err.print(words[i] + "/" + result[i] + "\n ");
			}
			System.err.println("n");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
