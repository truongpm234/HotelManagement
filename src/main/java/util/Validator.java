/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import data.Hotel;
import java.util.ArrayList;

/**
 *
 * @author phamm
 */
public class Validator {

    public boolean isDuplicateId(String id, ArrayList<Hotel> hotel) {
        for (Hotel o : hotel) {
            if (o.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public int isDuplicateId(String id, ArrayList<Hotel> hotel, boolean cont) {
        int count = 0;
        if (cont == true || cont == false) {
            for (Hotel o : hotel) {
                if (o.getId().equals(id)) {
                    return count;
                }
                count++;
            }
        }
        return -1;
    }

    public boolean isValidId(String id) {
        if (id == null) {
            return false;
        }
        return true;
    }

    public boolean isValidName(String name) {
        if (name == null) {
            return false;
        }
        return true;
    }

    public boolean isValidAddress(String address) {
        if (address == null) {
            return false;
        }
        return true;
    }

    public boolean checkNull(String check) {
        if (check == null) {
            return true;
        }
        return false;
    }

    public boolean isValidPhoneNumber(String phone) {
        return phone != null && phone.matches("0\\d{9}");
    }

    public boolean isValidRating(String rating) {
    return rating == null || rating.trim().isEmpty() || (Integer.parseInt(rating) >= 1 && Integer.parseInt(rating) <= 6);
}

    public boolean checkNull(Integer check) {
        if (check == null) {
            return true;
        }
        return false;
    }

    public boolean checkNullAll(String check1, String check2, String check3, String check4, Integer id, Integer room) {
        if ((check1 == null) && (check2 == null) && (check3 == null) && (check4 == null) && (id == null) && (room == null)) {
            return true;
        }
        return false;
    }

    public boolean checkAtLeastNull(String check1, String check2, String check3, String check4, Integer id, Integer room) {
        if ((check1 == null) || (check2 == null) || (check3 == null) || (check4 == null) || (id == null) || (room == null)) {
            return true;
        }
        return false;
    }
}
