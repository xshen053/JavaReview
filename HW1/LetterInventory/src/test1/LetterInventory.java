package test1;

import java.util.ArrayList;

public class LetterInventory {
    public String input;
    public int size;
    public int[] inventory;
    public static final int DEFAULT_CAPACITY = 26;

    /**
     * Constructs an inventory (a count) of the alphabetic letters in the given string,
     * ignoring the case of letters and ignoring any non-alphabetic characters.
     *
     * @param data
     */
    LetterInventory(String data) {
        input = data;
        data = data.toLowerCase();
        inventory = new int[DEFAULT_CAPACITY];
        int count = 0;
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) < 'a' || data.charAt(i) > 'z') {
                continue;
            } else {
                inventory[data.charAt(i) - 'a']++;
                count++;
            }
        }
        size = count;
    }

    /**
     * Returns a count of how many of this letter are in the inventory. Letter might
     * be lowercase or uppercase (your method shouldn’t care). If a nonalphabetic
     * character is passed, your method should throw an IllegalArgumentException.
     *
     * @param letter
     * @return number of letter in the inventory
     * @throws IllegalArgumentException if a nonalphabeti character is passed
     *
     */
    public int get(char letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException();
        } else {
            char lower = Character.toLowerCase(letter);
            return inventory[lower - 'a'];
        }
    }

    /**
     * Sets the count for the given letter to the given value. Letter might be
     * lowercase or uppercase. If a nonalphabetic character is passed or if value is
     * negative, your method should throw an IllegalArgumentException
     *
     * @param letter
     * @param value
     * @throws IllegalArgumentException if value < 0 or letter is a nonalphabetic character
     */
    public void set(char letter, int value) {
        if (!Character.isLetter(letter) || value < 0) {
            throw new IllegalArgumentException();
        } else {
            char lower = Character.toLowerCase(letter);
            size -= inventory[lower - 'a'] - value;
            inventory[lower - 'a'] = value;
        }
    }

    /**
     * Returns the sum of all of the counts in this inventory. This operation should
     * be “fast” in that it should store the size rather than having to compute it each
     * time this method is called.
     *
     * @return the sum of all of the counts in this inventory.
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this inventory is empty (all counts are 0). This operation
     * should be fast in that it should not need to examine each of the 26 counts
     * when it is called.
     *
     * @return true if this inventory is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a String representation of the inventory with the letters all in
     * lowercase and in sorted order and surrounded by square brackets. The
     * number of occurrences of each letter should match its count in the inventory.
     *
     * For example, an inventory of 4 a’s, 1 b, 1 l and 1 m would be represented as
     * “[aaaablm]”
     *
     * @return
     */
    public String toString() {
        String result = "[";
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            for (int j = 0; j < inventory[i]; j++) {
                result += (char) ('a' + i);
            }
        }
        result += ']';
        return result;
    }

    /**
     * Constructs and returns a new LetterInventory object that represents the sum
     * of this letter inventory and the other given LetterInventory. The counts for
     * each letter should be added together. The two LetterInventory objects being
     * added together (this and other) should not be changed by this method
     *
     * @param other
     * @return
     */
    LetterInventory add(LetterInventory other) {
        return new LetterInventory(input + other.input);
    }

    /**
     * Constructs and returns a new LetterInventory object that represents the result
     * of subtracting the other inventory from this inventory (i.e., subtracting the
     * counts in the other inventory from this object’s counts). If any resulting
     * count would be negative, your method should return null. The two
     * LetterInventory objects being subtracted (this and other) should not be
     * changed by this method
     *
     * @param other
     * @return
     */
    LetterInventory subtract(LetterInventory other){return this;}
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}