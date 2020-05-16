package com.dkb.bloom.filter;

import com.dkb.bloom.filter.controller.Controller;
import com.dkb.bloom.filter.controller.FilterController;

import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        System.out.println("LOADING : Please wait ...");
        final var controller = new FilterController();
        controller.setSlot(3000000);
        controller.execute();
        MainApplication app = new MainApplication();
        app.readLine(controller);
    }

    private void readLine(final Controller controller) {
        final var scanner = new Scanner(System.in);
        System.out.println("WELCOME : Please write a word to search :");
        var text = "";
        do {
            text = scanner.nextLine();
            final var result = controller.mightContain(text);
            System.out.println(String.format("RESULT : %s might contain : %s", text, result));
        } while (!text.equalsIgnoreCase("exit"));
    }

}
