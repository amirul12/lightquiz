package com.demiurgosoft.lightquiz;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by demiurgosoft - 4/10/15
 */
public class SoundHandler {
    Context context;
    private MediaPlayer correctAnswer;
    private MediaPlayer wrongAnswer;
    private MediaPlayer questionSound = null;

    public SoundHandler(Context context) {
        this.context = context;
        correctAnswer = MediaPlayer.create(context, R.raw.correct_answ);
        wrongAnswer = MediaPlayer.create(context, R.raw.wrong_answ);
        //   correctAnswer=MediaPlayer.create(context, R.raw.wrong_answ);
    }

    public void playCorrectSound() {
        correctAnswer.start();
    }

    public void playWrongSound() {
        wrongAnswer.start();
    }

    public void playQuestionSound() {
        stopQuestionSound();
        questionSound.start();
    }

    public void stopQuestionSound() {
        if (questionSound != null && questionSound.isPlaying()) questionSound.stop();

    }
    public void setQuestionSound(String soundname) {
        int resourceId = context.getResources().getIdentifier(soundname, "raw", context.getPackageName());
        questionSound = MediaPlayer.create(context, resourceId);
    }

}
