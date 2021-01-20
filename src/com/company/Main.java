package com.company;


import java.util.*;

public class Main {

    private static List<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album album = new Album("Once", "Nightwish");
        album.addSong("Dark Chest of Wonders", 4.6);
        album.addSong("Wish I Had An Angel", 4.22);
        album.addSong("Nemo", 4.3);
        album.addSong("Planet Hell", 5.6);
        album.addSong("Creek Mary's Blood", 3.21);
        album.addSong("The Siren", 6.23);
        album.addSong("Dead Gardens", 4.21);
        album.addSong("Romanticide", 4.2);
        album.addSong("Ghost Love Score", 3.13);
        albums.add(album);

        album = new Album("The Cleansing ", "Suicide Silence");
        album.addSong("Revelations (Intro)", 5.44);
        album.addSong("Unanswered", 3.25);
        album.addSong("Hands of a Killer", 3.45);
        album.addSong("The Price of Beauty", 3.33);
        album.addSong("No Pity for a Coward", 4.51);
        album.addSong("Girl of Glass", 3.45);
        album.addSong("In a Photograph", 5.32);
        album.addSong("Destruction of a Statue", 5.12);
        albums.add(album);

        List<Song> playList = new ArrayList<>();
        albums.get(0).addToPlayList("Wish I Had An Angel", playList);
        albums.get(0).addToPlayList("Ghost Love Score", playList);
        albums.get(0).addToPlayList("Unanswered", playList); //does not exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList);//theres not track

        play(playList);


    }

    private static void play(List<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0){
            System.out.println("No songs in playlist");
            return;
        }else{
            System.out.println("Now playing " +listIterator.next().toString());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing " +listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing " +listIterator.previous().toString());
                    }else{
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying " +listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("We are at the start of the list");
                            forward = true;
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying " +listIterator.next().toString());
                        }else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                   printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " +listIterator.next());
                        }else if(listIterator.hasPrevious()){
                            System.out.println("Now playing " +listIterator.previous());
                        }
                    }
                    break;
            }
        }

    }

    private static void printMenu(){
        System.out.println("Available actions\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlis\n" +
                "5 - print available actions.\n" +
                "6 - remove current song from playlist");
    }

    private static void printList(List<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("===============================");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("===============================");
    }



















}
