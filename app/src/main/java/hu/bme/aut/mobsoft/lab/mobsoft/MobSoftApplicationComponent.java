package hu.bme.aut.mobsoft.lab.mobsoft;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.mobsoft.lab.mobsoft.interactor.InteractorModule;
import hu.bme.aut.mobsoft.lab.mobsoft.interactor.elementdetails.ElementDetailsInteractor;
import hu.bme.aut.mobsoft.lab.mobsoft.interactor.elementlist.ElementListInteractor;
import hu.bme.aut.mobsoft.lab.mobsoft.network.NetworkModule;
import hu.bme.aut.mobsoft.lab.mobsoft.repository.RepositoryModule;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.UIModule;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.elementdetails.ElementDetailsActivity;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.elementdetails.ElementDetailsPresenter;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.elementlist.ElementListActivity;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.elementlist.ElementListPresenter;
import hu.bme.aut.mobsoft.lab.mobsoft.ui.main.MainActivity;

/**
 * Created by Mobsoft on 2017. 03. 24..
 */

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class, RepositoryModule.class, NetworkModule.class})
public interface MobSoftApplicationComponent {
    void inject(MobSoftApplication mobSoftApplication);

    void inject(MainActivity mainActivity);
    void inject(ElementListActivity elementListActivity);
    void inject(ElementDetailsActivity elementDetailsActivity);

    void inject(ElementListPresenter elementListPresenter);
    void inject(ElementDetailsPresenter elementDetailsPresenter);

    void inject(ElementDetailsInteractor elementDetailsInteractor);
    void inject(ElementListInteractor elementListInteractor);
}