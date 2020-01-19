package com.alaameaad.likestory.helper;

public class HelperLink {
    public String hleperId (int id){
        String scriptJave = null;
        if (id == 2){
             scriptJave = "javascript: var likes = document.querySelectorAll('a[href*=\\\"subscribe.php\\\"]');if (likes.length >= 1){likes[0].click();}";
        }else if (id == 3) {
             scriptJave = "javascript: var likes = document.querySelectorAll('a[href*=\\\"profile.php?fan\\\"]');if (likes.length >= 1){likes[0].click();}";
        }else if (id == 4){
             scriptJave = "javascript: eval(atob('dmFyIGJ0blNoYXJlO2RvY3VtZW50LmxvY2F0aW9uLmhyZWYuaW5kZXhPZigic3JjPXNoYXJlIik+PTA/KGJ0blNoYXJlPWRvY3VtZW50LnF1ZXJ5U2VsZWN0b3IoImlucHV0W3R5cGU9J3N1Ym1pdCddW25hbWU9J3ZpZXdfcG9zdCddIikpJiZidG5TaGFyZS5jbGljaygpOihidG5TaGFyZT1kb2N1bWVudC5xdWVyeVNlbGVjdG9yKCJhW2hyZWYqPSdzcmM9c2hhcmUnXSIpKSYmYnRuU2hhcmUuY2xpY2soKTs='));";
        }else if (id == 6){
             scriptJave = "javascript: eval(atob('dmFyIGJ0blJlYWN0aW9uLHJlYWN0aW9uTnVtYmVyPTE7ZG9jdW1lbnQubG9jYXRpb24uaHJlZi5pbmRleE9mKCJyZWFjdGlvbiIpPj0wPyhidG5SZWFjdGlvbj1kb2N1bWVudC5xdWVyeVNlbGVjdG9yKCJhW2hyZWYqPSdyZWFjdGlvbl90eXBlPSIrcmVhY3Rpb25OdW1iZXIrIiddIikpJiZidG5SZWFjdGlvbi5jbGljaygpOihidG5SZWFjdGlvbj1kb2N1bWVudC5xdWVyeVNlbGVjdG9yKCJhW2hyZWYqPSdyZWFjdGlvbnMvcGlja2VyJ10iKSkmJmJ0blJlYWN0aW9uLmNsaWNrKCk7'));";
        }else if (id == 7){
             scriptJave = "javascript: eval(atob('dmFyIGJ0blJlYWN0aW9uLHJlYWN0aW9uTnVtYmVyPTI7ZG9jdW1lbnQubG9jYXRpb24uaHJlZi5pbmRleE9mKCJyZWFjdGlvbiIpPj0wPyhidG5SZWFjdGlvbj1kb2N1bWVudC5xdWVyeVNlbGVjdG9yKCJhW2hyZWYqPSdyZWFjdGlvbl90eXBlPSIrcmVhY3Rpb25OdW1iZXIrIiddIikpJiZidG5SZWFjdGlvbi5jbGljaygpOihidG5SZWFjdGlvbj1kb2N1bWVudC5xdWVyeVNlbGVjdG9yKCJhW2hyZWYqPSdyZWFjdGlvbnMvcGlja2VyJ10iKSkmJmJ0blJlYWN0aW9uLmNsaWNrKCk7'));";
        }else if (id == 9){
             scriptJave = "javascript: eval(atob('dmFyIGJ0blJlYWN0aW9uLHJlYWN0aW9uTnVtYmVyPTQ7ZG9jdW1lbnQubG9jYXRpb24uaHJlZi5pbmRleE9mKCJyZWFjdGlvbiIpPj0wPyhidG5SZWFjdGlvbj1kb2N1bWVudC5xdWVyeVNlbGVjdG9yKCJhW2hyZWYqPSdyZWFjdGlvbl90eXBlPSIrcmVhY3Rpb25OdW1iZXIrIiddIikpJiZidG5SZWFjdGlvbi5jbGljaygpOihidG5SZWFjdGlvbj1kb2N1bWVudC5xdWVyeVNlbGVjdG9yKCJhW2hyZWYqPSdyZWFjdGlvbnMvcGlja2VyJ10iKSkmJmJ0blJlYWN0aW9uLmNsaWNrKCk7'));";
        }else if (id == 10){
             scriptJave = "javascript: eval(atob('dmFyIGJ0blJlYWN0aW9uLHJlYWN0aW9uTnVtYmVyPTM7ZG9jdW1lbnQubG9jYXRpb24uaHJlZi5pbmRleE9mKCJyZWFjdGlvbiIpPj0wPyhidG5SZWFjdGlvbj1kb2N1bWVudC5xdWVyeVNlbGVjdG9yKCJhW2hyZWYqPSdyZWFjdGlvbl90eXBlPSIrcmVhY3Rpb25OdW1iZXIrIiddIikpJiZidG5SZWFjdGlvbi5jbGljaygpOihidG5SZWFjdGlvbj1kb2N1bWVudC5xdWVyeVNlbGVjdG9yKCJhW2hyZWYqPSdyZWFjdGlvbnMvcGlja2VyJ10iKSkmJmJ0blJlYWN0aW9uLmNsaWNrKCk7'));";
        }else if (id == 11){
             scriptJave = "javascript: eval(atob('dmFyIGJ0blJlYWN0aW9uLHJlYWN0aW9uTnVtYmVyPTc7ZG9jdW1lbnQubG9jYXRpb24uaHJlZi5pbmRleE9mKCJyZWFjdGlvbiIpPj0wPyhidG5SZWFjdGlvbj1kb2N1bWVudC5xdWVyeVNlbGVjdG9yKCJhW2hyZWYqPSdyZWFjdGlvbl90eXBlPSIrcmVhY3Rpb25OdW1iZXIrIiddIikpJiZidG5SZWFjdGlvbi5jbGljaygpOihidG5SZWFjdGlvbj1kb2N1bWVudC5xdWVyeVNlbGVjdG9yKCJhW2hyZWYqPSdyZWFjdGlvbnMvcGlja2VyJ10iKSkmJmJ0blJlYWN0aW9uLmNsaWNrKCk7'));";
        }else if (id == 12){
             scriptJave = "javascript: eval(atob('dmFyIGJ0blJlYWN0aW9uLHJlYWN0aW9uTnVtYmVyPTg7ZG9jdW1lbnQubG9jYXRpb24uaHJlZi5pbmRleE9mKCJyZWFjdGlvbiIpPj0wPyhidG5SZWFjdGlvbj1kb2N1bWVudC5xdWVyeVNlbGVjdG9yKCJhW2hyZWYqPSdyZWFjdGlvbl90eXBlPSIrcmVhY3Rpb25OdW1iZXIrIiddIikpJiZidG5SZWFjdGlvbi5jbGljaygpOihidG5SZWFjdGlvbj1kb2N1bWVudC5xdWVyeVNlbGVjdG9yKCJhW2hyZWYqPSdyZWFjdGlvbnMvcGlja2VyJ10iKSkmJmJ0blJlYWN0aW9uLmNsaWNrKCk7'));";
        }else if (id == 13){
             scriptJave = "javascript: eval(atob('ZG9jdW1lbnQucXVlcnlTZWxlY3RvckFsbCgiLmMzLW1hdGVyaWFsLWJ1dHRvbi1idXR0b24iKVswXS5jbGljaygp'))\n";
        }else if (id == 14){
             scriptJave = "javascript: eval(atob('ZG9jdW1lbnQucXVlcnlTZWxlY3RvckFsbCgiLmMzLW1hdGVyaWFsLWJ1dHRvbi1idXR0b24iKVswXS5jbGljaygp'))\n";
        }else if (id == 15){
             scriptJave = "javascript: eval(atob('ZG9jdW1lbnQucXVlcnlTZWxlY3RvckFsbCgiYVtocmVmKj0nZmF2b3JpdGUnXSIpWzBdLmNsaWNrKCk7'))\n";
        }else if (id == 16){
             scriptJave = "javascript: eval(atob('ZG9jdW1lbnQucXVlcnlTZWxlY3RvckFsbCgiZm9ybVthY3Rpb24qPSdmb2xsb3cnXVttZXRob2Q9J3Bvc3QnXSIpWzBdLnN1Ym1pdCgpOw'))\n";
        }

        return scriptJave;
    }
}
