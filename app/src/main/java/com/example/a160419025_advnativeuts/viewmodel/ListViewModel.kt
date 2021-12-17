package com.example.a160419025_advnativeuts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.RequestQueue
import com.example.a160419025_advnativeuts.model.Recipe
import java.util.*

class ListViewModel: ViewModel() {
    val recipeLD = MutableLiveData<List<Recipe>>()
    val TAG = "volleyTag"
    private var queue: RequestQueue ?= null

    fun refresh () {
        val recipe1 = Recipe(
            "Rice Bowl Sei Sapi Sambal Matah (Khas NTT)",
            "Bahan Se'i Sapi\n" +
                    "200 gr daging sapi Has dlm\n" +
                    "1/2 sdt garam/secukupnya\n" +
                    "1/2 sdt lada bubuk/secukupnya\n" +
                    "Bahan Rempah Aromatik\n" +
                    "4 lmbr daun salam\n" +
                    "2 lmbr daun jeruk\n" +
                    "1 lmbr daun pndang, potong²\n" +
                    "1 btg sereh, geprek\n" +
                    "2 cm lengkuas, geprek\n" +
                    "20 gr beras\n" +
                    "10 gr gula palem\n" +
                    "Bahan Sambal Matah\n" +
                    "8 siung bwg merah, iris\n" +
                    "1 siung bwg putih uk besar, iris\n" +
                    "8 buah cabe rawit merah, iris\n" +
                    "2 lmbr daun jeruk, iris halus\n" +
                    "1 btg sereh, ambil bgian putih'a, iris halus\n" +
                    "1/4 sdt terasi, sangrai\n" +
                    "1/4 sdt gula pasir\n" +
                    "1/8 Sdt garam / sejumput\n" +
                    "1/2 buah jeruk sambal, ambil air'a\n" +
                    "3 sdm minyak panas\n" +
                    "Bahan Tumisan Sayur\n" +
                    "20 lmbr daun pepaya jepang\n" +
                    "30 gr daun ubi/singkong\n" +
                    "1 buah bwg merah, iris\n" +
                    "1 siung bwg putih, iris\n" +
                    "2 buah cabe merah, iris serong\n" +
                    "1 buah cabe hijau, iris serong\n" +
                    "1/4 sdt garam\n" +
                    "1/4 sdt gula\n" +
                    "1/4 sdt kaldu jamur\n" +
                    "Pelengkap\n" +
                    "Nasi putih\n" +
                    "Es teh Manis\uD83D\uDE05 (optional)",
            "https://img-global.cpcdn.com/recipes/bf5b0e61196c4fe7/680x482cq70/rice-bowl-sei-sapi-sambal-matah-khas-ntt-foto-resep-utama.webp",
            "Artem Danylo"
        )
        val recipe2 = Recipe(
            "Rice Bowl Chicken Curry and Cheese / Nasi Ayam Kari Keju",
            "250 g daging ayam kampung\n" +
                    "125 ml santan\n" +
                    "sesuai selera Gula aren\n" +
                    "sesuai selera Garam laut\n" +
                    "sesuai selera Merica\n" +
                    "3 mangkok nasi putih\n" +
                    "Bumbu tumbuk\n" +
                    "3 siung bawang merah\n" +
                    "2 siung bawang putih\n" +
                    "2 kemiri\n" +
                    "5 cm kunyit\n" +
                    "1/2 sdt jintan\n" +
                    "1 sdt ketumbar\n" +
                    "1/2 buah pala\n" +
                    "Bahan pelengkap\n" +
                    "1 sdm biji wijen\n" +
                    "Irisan cabe\n" +
                    "Irisan daun bawang\n" +
                    "50 g keju parut\n" +
                    "Bshan oles\n" +
                    "1 sdm kecap manis\n" +
                    "1 sdm minyak kelapa",
            "https://img-global.cpcdn.com/recipes/672c126fc52447c8/680x482cq70/105-rice-bowl-chicken-curry-and-cheese-nasi-ayam-kari-keju-foto-resep-utama.webp",
            "Iris Olga"
        )

        val recipe3 = Recipe(
            "Kue lapis ombre-kue lapis kekinian-lapis pepe",
            "Bahan-bahan\n" +
                    "1000 ml air bersih\n" +
                    "200 ml santan kental (saya menggunakan santan instan kara@200ml)\n" +
                    "1/2 sdt vanili esens (optional)\n" +
                    "1/4 sdt garam\n" +
                    "250 g tepung kanji/tapioka (sy pke merk rosebrand)\n" +
                    "200 g tepung terigu protein sedang (sy pke segitiga)\n" +
                    "390-400 gr gula pasir (saya 390 Krn Tdk suka terlalu manis)\n" +
                    "Pewarna makanan ungu\n" +
                    "2 lembar Peralatan: Daun pandan\n" +
                    "Panci pengukus\n" +
                    "Loyang ukuran 18x18x5 cm\n" +
                    "Langkah\n" +
                    "Isi air ke panci pengukus.masukkan daun pandan.pasang sarangannya lalu tutup. alasi tutup dengan serbet.jika menggunakan tutup panci kaca,Tdk perlu pke kain.masukkan loyang yang sudah dioles minyak goreng taau dialasi baking paper.nyalakan api kecil saja dulu sambil kita membuat adonan.\n" +
                    "Campur semua bahan jadi satu kecuali pewarna makanan.\n" +
                    "Bagi adonan kedalam 6 wadah sama banyak.wadah pertama biarkan putih,adonan kedua kasih pewarna ungu 1 tetes,wadah ketiga 2 tetes,wadah keempat 3 tetes,wadah kelima 4 tetes,dan wadah keenam kasih 7 tetes agar lebih hidup warnanya nanti.\n" +
                    "Nah,keenam wadah ini kita bagi lagi jadi 3 masing2 sama banyak.\n" +
                    "Contoh: wadah warna putih bagi 3.jadi total ada 18 bagian nanti.artinya 1 wadah kita kukus sebanyak 3x.\n" +
                    "Kita mulai mengukus dari warna putih.warna putih ini adonannya sekitar 315ml.jadi saya bagi 3 lagi.jadi masing2 perlapis saya kukus sekitar 105ml.tuang ke loyang.ratakan.kukus selama 5 menit api keci agar tidak bergelombang nanti.\n" +
                    "Setelah lapisan pertama matang,tuang lagi lapisan putih kedua sebanyak 105ml.kukus lagi 5 menit.setelah lapisan kedua mtaang,tuang lagi lapisan putih ketiga (terakhir).kukus 5 menit.ok,lapisan putih sudah selesai",
            "https://img-global.cpcdn.com/recipes/0273f530b428184e/680x482cq70/kue-lapis-ombre-kue-lapis-kekinian-lapis-pepe-foto-resep-utama.webp",
            "Sarika Kateryna"
        )

        recipeLD.value = arrayListOf<Recipe>(recipe1, recipe2, recipe3)
    }
}