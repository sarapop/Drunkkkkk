package lib;

import javafx.scene.media.AudioClip;

public class AudioUtility {
	
	private static final String no = "se/no.wav";
	private static final String crash = "se/crash.wav";
	private static final String collect = "se/collect.wav";
	private static AudioClip sound_no;
	private static AudioClip sound_crash;
	private static AudioClip sound_collect;
	static {
		loadResource();
	}

	public static void loadResource() {
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		sound_no = new AudioClip(loader.getResource(no).toString());
		sound_crash = new AudioClip(loader.getResource(crash).toString());
		sound_collect = new AudioClip(loader.getResource(collect).toString());
	}

	public static void playSound(String identifier) {
		if (identifier == "crash") {
			sound_crash.play();
		} else if (identifier == "collect") {
			sound_collect.play();
		} else if (identifier == "no") {
			sound_no.play();
		}
	}

}
