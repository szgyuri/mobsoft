package hu.bme.aut.mobsoft.lab.mobsoft.interactor;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.mobsoft.lab.mobsoft.interactor.elementdetails.ElementDetailsInteractor;
import hu.bme.aut.mobsoft.lab.mobsoft.interactor.elementlist.ElementListInteractor;

/**
 * Created by Szabo Gyorgy on 2017. 04. 07..
 */

@Module
public class InteractorModule {
    @Provides
    public ElementListInteractor provideElementListInteractor() {
        return new ElementListInteractor();
    }

    @Provides
    public ElementDetailsInteractor provideElementDetailsInteractor() {
        return new ElementDetailsInteractor();
    }
}
