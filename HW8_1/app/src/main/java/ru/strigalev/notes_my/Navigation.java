package ru.strigalev.notes_my;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import ru.strigalev.notes_my.fragment.NoteListFragment;


public class Navigation {

    private FragmentManager fragmentManager = null;

    //public Navigation(FragmentManager fragmentManager){
      //  this.fragmentManager = fragmentManager;
   // }

    public Navigation(androidx.fragment.app.FragmentManager supportFragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void addFragment(Fragment fragment, boolean useBackStack) {
        // Открыть транзакцию
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        if (useBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        // Закрыть транзакцию
        fragmentTransaction.commit();
    }

    public void removeFragment() {
        fragmentManager.popBackStack();
    }
}
