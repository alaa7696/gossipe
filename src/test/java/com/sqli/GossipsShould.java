package com.sqli;

import org.junit.Test;
import junit.framework.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class GossipsShould {
    @Test
    public void bePropagatedByAnyMister() {

        Gossips gossips = new Gossips("Mr White", "Mr Black", "Mr Blue")
                .from("White").to("Black").from("Black").to("Blue");

        gossips.say("Hello").to("White");


        assertEquals("Hello",gossips.ask("White"));
        System.out.println(1);
        gossips.spread();

        assertEquals("",gossips.ask("White"));

        assertEquals("Hello",gossips.ask("Black"));
        System.out.println(2);
        gossips.spread();

        assertEquals("",gossips.ask("Black"));
        assertEquals("Hello",gossips.ask("Blue"));

    }

    @Test
    public void beRetainedIfRecipientHasAlreadyAGossip() {

        Gossips gossips = new Gossips("Mr White", "Mr Black", "Mr Blue")
                .from("White").to("Black").from("Blue").to("Black");

        gossips.say("Hello").to("White");
        gossips.say("Secret").to("Blue");

        System.out.println("1");
        assertEquals("Hello",gossips.ask("White"));
        assertEquals("Secret",gossips.ask("Blue"));

        gossips.spread();
        System.out.println("2");
        assertEquals("",gossips.ask("White"));
        assertEquals("Hello",gossips.ask("Black"));
        assertEquals("Secret",gossips.ask("Blue"));

        gossips.spread();
        System.out.println("3");
        assertEquals("",gossips.ask("White"));
        assertEquals("Secret",gossips.ask("Black"));
        assertEquals("",gossips.ask("Blue"));

    }


    @Test
    public void beRememberedByDoctors() {

        Gossips gossips = new Gossips("Mr White", "Mr Black", "Dr Brown",
                "Mr Pink").from("White").to("Brown").from("Black").to("Brown")
                .from("Brown").to("Pink");

        gossips.say("Hello").to("White");
        gossips.say("ByeBye").to("Black");

        gossips.spread();

        System.out.println("1");
        assertEquals("Hello",gossips.ask("Brown"));
        assertEquals("",gossips.ask("Pink"));

        gossips.spread();
        System.out.println(2);
        assertEquals("Hello, ByeBye",gossips.ask("Brown"));

        assertEquals("Hello",gossips.ask("Pink"));

        gossips.spread();

        assertEquals("Hello, ByeBye",gossips.ask("Brown"));
        assertEquals("ByeBye",gossips.ask("Pink"));

    }


    @Test
    public void alwaysBeListenedByAnAgent() {

        Gossips gossips = new Gossips("Mr White", "Mr Grey", "Agent Pink",
                "Mr Blue").from("White").to("Pink").from("Grey").to("Pink")
                .from("Pink").to("Blue");

        gossips.say("Hello").to("White");
        gossips.say("Shade").to("Grey");

        gossips.spread();

        assertEquals("",gossips.ask("Blue"));
        assertEquals("",gossips.ask("Blue"));
        assertEquals("Hello, Shade",gossips.ask("Pink"));

        gossips.spread();
        System.out.println(3);
        assertEquals("",gossips.ask("Pink"));
        System.out.println(4);

        assertEquals("",gossips.ask("Blue"));
    }

    @Test
    public void beStoppedByAnAgent() {

        Gossips gossips = new Gossips("Mr White", "Agent Pink", "Mr Blue")
                .from("White").to("Pink").from("Pink").to("Blue");

        gossips.say("Hello").to("White");

        gossips.spread();

        assertEquals("Hello",gossips.ask("Pink"));
        assertEquals("",gossips.ask("Blue"));

        gossips.spread();

        assertEquals("",gossips.ask("Pink"));
        assertEquals("",gossips.ask("Blue"));
    }

    /*
    @Test
    public void beDelayedOneTurnByAProfessor() {

        Gossips gossips = new Gossips("Mr White", "Pr Pink", "Mr Blue")
                .from("White").to("Pink").from("Pink").to("Blue");

        gossips.say("Hello").to("White");

        gossips.spread();

        assertEquals("Hello",gossips.ask("Pink"));
        assertEquals("",gossips.ask("Blue"));

        gossips.spread();

        assertEquals("Hello",gossips.ask("Pink"));
        assertEquals("",gossips.ask("Blue"));

        gossips.spread();

        assertEquals("",gossips.ask("Pink"));
        assertEquals("Hello",gossips.ask("Blue"));
    }


    @Test
    public void bePropagatedByALadyWhenComingFromADoctor() {

        Gossips gossips = new Gossips("Dr Black", "Lady Green", "Agent Pink")
                .from("Black").to("Green").from("Green").to("Pink");

        gossips.say("Secret").to("Black");

        gossips.spread();

        assertThat(gossips.ask("Green")).isEqualTo("Secret");

        gossips.spread();

        assertThat(gossips.ask("Pink")).isEqualTo("Secret");

    }

    @Test
    public void notBePropagatedByALadyWhenComingAMister() {

        Gossips gossips = new Gossips("Mr White", "Lady Green", "Agent Pink")
                .from("White").to("Green").from("Green").to("Pink");

        gossips.say("Hello").to("White");

        gossips.spread();

        assertThat(gossips.ask("Green")).isEqualTo("Hello");

        gossips.spread();

        assertThat(gossips.ask("Pink")).isEqualTo("");

    }

    @Test
    public void beReturnedAndInvertedByGentlemen() {

        Gossips gossips = new Gossips("Mr White", "Sir Rose", "Mr Black")
                .from("White").to("Rose").from("Rose").to("Black");

        gossips.say("Hello").to("White");

        gossips.spread();

        assertThat(gossips.ask("White")).isEqualTo("");
        assertThat(gossips.ask("Rose")).isEqualTo("Hello");
        assertThat(gossips.ask("Black")).isEqualTo("");

        gossips.spread();

        assertThat(gossips.ask("White")).isEqualTo("olleH");
        assertThat(gossips.ask("Rose")).isEqualTo("");
        assertThat(gossips.ask("Black")).isEqualTo("");

        gossips.spread();

        assertThat(gossips.ask("White")).isEqualTo("");
        assertThat(gossips.ask("Rose")).isEqualTo("olleH");
        assertThat(gossips.ask("Black")).isEqualTo("");
    }*/
}
