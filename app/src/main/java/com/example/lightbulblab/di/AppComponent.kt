package com.example.lightbulblab.di

import com.example.lightbulblab.di.viewModel.ViewModelModule
import com.example.lightbulblab.presenter.MainFragment
import dagger.Component
import dagger.Module

@Component(
    modules = [AppModule::class]
)
abstract class AppComponent {
    abstract fun inject(fragment: MainFragment)
}

@Module(
    includes = [
        NetworkModule::class,
        AppBindsModule::class,
        ViewModelModule::class,
    ]
)
class AppModule