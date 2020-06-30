package com.example.encyclopedie




import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = [Pays::class], version = 1, exportSchema = false)
@TypeConverters(ConverterList::class)
public abstract class PaysDataBase : RoomDatabase() {

    abstract fun paysDao(): PaysDao

    companion object {
        @Volatile
        private var INSTANCE: PaysDataBase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): PaysDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PaysDataBase::class.java,
                    "word_database"
                )
                    .addCallback(PaysDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private class PaysDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            /**
             * Override the onOpen method to populate the database.
             * For this sample, we clear the database every time it is created or opened.
             */
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.paysDao())
                    }
                }
            }
        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more words, just add them.
         */
        suspend fun populateDatabase(paysDao: PaysDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            paysDao.deleteAll()

            var ressource : ArrayList<String> = ArrayList()
            ressource.add("petrole")
            ressource.add(" gas")
            ressource.add("solar and wind power")
            var personnal : ArrayList<String> = ArrayList()
            personnal.add("funny ")
            personnal.add("lazy")
            personnal.add("helpful")
            var Histo :ArrayList<String> = ArrayList()
            Histo.add("1830 : French colonization")
            Histo.add("01 Novembre 1954 : Algerian Civil War")
            Histo.add("05 Juillet 1962 : Independence Day")

            var videoPathdz1 =
                "android.resource://com.example.encyclopedie/" + R.raw.algeria_beautiful_places
            var videoPathdz2 =
                "android.resource://com.example.encyclopedie/" + R.raw.historique_dz
            val videos : ArrayList<String> = ArrayList()

            val titles :ArrayList<String> =ArrayList()
            titles.add("Les belles places en Algerie")
            titles.add("Historique de l'Algérie")
            videos.add(videoPathdz1)
            videos.add(videoPathdz2)

            var ressource2 : ArrayList<String> = ArrayList()
            ressource2.add(" l'électricité et  gaz ")
            ressource2.add("  les céréales (blé et orge), les olives")
            ressource2.add("solar power")
            var personnal2 : ArrayList<String> = ArrayList()
            personnal2.add("funny ")
            personnal2.add("lazy")
            personnal2.add("helpful")
            var Histo2 :ArrayList<String> = ArrayList()
            Histo2.add("20 mars 1956 : Independence de la France")
            Histo2.add("26 avril 1861 : Première Constitution")
            Histo2.add("14 janvier 2011 : Revolution tunisienne")

            var videoPathtun1 =
                "android.resource://com.example.encyclopedie/" + R.raw.tunisie
            var videoPathtun2 =
                "android.resource://com.example.encyclopedie/" + R.raw.historique_dz
            val videos2 : ArrayList<String> = ArrayList()

            val titles2 :ArrayList<String> =ArrayList()
            titles2.add("Les belles places en Tunisie")
            titles2.add("Historique de Tunisie")
            videos2.add(videoPathtun1)
            videos2.add(videoPathtun2)

            var ressource3 : ArrayList<String> = ArrayList()
            ressource3.add(" les îles Baléares")
            ressource3.add(" les îles Canaries")
            ressource3.add("Le charbon")
            var personnal3 : ArrayList<String> = ArrayList()
            personnal3.add("funny ")
            personnal3.add("lazy")
            personnal3.add("helpful")
            var Histo3 :ArrayList<String> = ArrayList()
            Histo3.add("409 : Invasions barbares et Royaume wisigoth")
            Histo3.add("711 :  Al-Andalus et royaumes chrétiens de la Reconquista")
            Histo3.add("1975 : Restauration monarchique")


            var videoPatheng1 =
                "android.resource://com.example.encyclopedie/" + R.raw.espagne
            var videoPatheng2 =
                "android.resource://com.example.encyclopedie/" + R.raw.historique_dz
            val videos3 : ArrayList<String> = ArrayList()

            val titles3 :ArrayList<String> =ArrayList()
            titles3.add("Les belles places en Espagne")
            titles3.add("Historique de l'Espagne")
            videos3.add(videoPatheng1)
            videos3.add(videoPatheng2)

            var ressource4 : ArrayList<String> = ArrayList()
            ressource4.add("le charbon ")
            ressource4.add("Industrie")
            ressource4.add("Stations balnéaires")
            var personnal4 : ArrayList<String> = ArrayList()
            personnal4.add("strict ")
            personnal4.add("hard workers")
            personnal4.add("helpful")
            var Histo4 :ArrayList<String> = ArrayList()
            Histo4.add("1945 : Occupation alliée")
            Histo4.add("9 novembre 1989 : Chute de Mur")
            Histo4.add("3 octobre 1990 : Réunification")

            var videoPathesp1 =
                "android.resource://com.example.encyclopedie/" + R.raw.allemagne
            var videoPathesp2 =
                "android.resource://com.example.encyclopedie/" + R.raw.historique_dz
            val videos4 : ArrayList<String> = ArrayList()

            val titles4 :ArrayList<String> =ArrayList()
            titles4.add("Les belles places en Allemagne")
            titles4.add("Historique de l'Allemagne")
            videos4.add(videoPathesp1)
            videos4.add(videoPathesp2)

            var ressource5 : ArrayList<String> = ArrayList()
            ressource5.add("hydro-électricité")
            ressource5.add(" géothermie")
            ressource5.add("énergie nucléaire")
            var personnal5 : ArrayList<String> = ArrayList()
            personnal5.add("funny ")
            personnal5.add("cheerful")
            personnal5.add("helpful")
            var Histo5 :ArrayList<String> = ArrayList()
            Histo5.add("781 : Couronnement de Pépin d'Italie")
            Histo5.add("17 mars 1861 : Unification")
            Histo5.add("2 juin 1946 : République")

            var videoPathal1 =
                "android.resource://com.example.encyclopedie/" + R.raw.tunisie
            var videoPathal2 =
                "android.resource://com.example.encyclopedie/" + R.raw.historique_dz
            val videos5 : ArrayList<String> = ArrayList()

            val titles5 :ArrayList<String> =ArrayList()
            titles5.add("Les belles places en Italie")
            titles5.add("Historique de l'Italie")
            videos5.add(videoPathal1)
            videos5.add(videoPathal2)

            var pays = Pays("Algerie","Algerie est un pays d’Afrique du Nord faisant partie du Maghreb. Depuis 1962, elle est nommée en forme longue République algérienne démocratique et populaire",
                2381741 ,43600000,Histo,ressource,personnal,R.raw.hymne_algerie,R.drawable.flag,
                R.drawable.imagedz1,R.drawable.imagedz2,R.drawable.imagedz3,videos,titles)
            paysDao.insert(pays)
            pays =Pays("Tunisie","Tunisie est un État d'Afrique du Nord bordé au nord et à l'est par la mer Méditerranée (1 566 kilomètres de côtes9), à l'ouest par l'Algérie avec 965 kilomètres de frontière commune et au sud-sud-est par la Libye avec 459 kilomètres de frontière. Sa capitale Tunis",
                163610 ,11722038,Histo2,ressource2,personnal2,R.raw.hymne_tunisie,R.drawable.flag2,
                R.drawable.imagtn1,R.drawable.imagetn2,R.drawable.imagetn3,videos2,titles2)
            paysDao.insert(pays)
            pays = Pays("Espagne","Espagne est un pays d'Europe du Sud — et, selon les définitions, d'Europe de l'Ouest — qui occupe la plus grande partie de la péninsule Ibérique",
                505911 ,46934632,Histo3,ressource3,personnal3,R.raw.espagne_hymne,R.drawable.flag3,
                R.drawable.imagesp1,R.drawable.imagesp2,R.drawable.imagesp3,videos3,titles3)
            paysDao.insert(pays)
            pays =Pays("Allemagne","Allemagne est un pays d'Europe centrale, entouré par la mer du Nord, le Danemark et la mer Baltique au nord, par la Pologne à l'est-nord-est, par la Tchéquie à l'est-sud-est, par l'Autriche au sud-sud-est, par la Suisse au sud-sud-ouest, par la France au sud-ouest, par la Belgique et le Luxembourg à l'ouest, enfin par les Pays-Bas à l'ouest-nord-ouest",
                357386 ,83149300,Histo4,ressource4,personnal4,R.raw.germany_instrumental,R.drawable.flag4,
                R.drawable.imageal1,R.drawable.imageal2,R.drawable.imageal3,videos4,titles4)
            paysDao.insert(pays)
            pays =  Pays("Italie","Italie est un pays d'Europe du Sud correspondant physiquement à une partie continentale, une péninsule située au centre de la mer Méditerranée et une partie insulaire constituée par les deux plus grandes îles de cette mer, la Sicile et la Sardaigne, et beaucoup d'autres îles plus petites",
                301336 ,60359546,Histo5,ressource5,personnal5,R.raw.italy_son,R.drawable.flag5,
                R.drawable.imageit1,R.drawable.imageit2,R.drawable.imageit3,videos5,titles5)
            paysDao.insert(pays)
        }
    }

}
