# MVVM_Livedata_Coroutines_Retrofit_Hiilt_Caching
Google recommended clean architecture implementation using room as a local datasource and retrofit as remote data source.

The Rick and Morty Api is consumed in this project: https://rickandmortyapi.com/api/character

The caching stategy used at the repository involves retrieving data from room persistent storage when network is unavalaible, while data is retrieved from retrofit api when network is available

Hilt is used for dependency injection and Kotlin Coroutines is used for asynchronous operation.
