package hu.bme.aut.mobsoft.lab.mobsoft;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.UIModule;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.main.MainActivity;

/**
 * Created by Mobsoft on 2017. 03. 24..
 */

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

}