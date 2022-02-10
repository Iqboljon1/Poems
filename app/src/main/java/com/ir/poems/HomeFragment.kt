package com.ir.poems

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ir.poems.DataClassPoems.DataClassPoems
import com.ir.poems.MyShare.MyShare
import com.ir.poems.Object.Object
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    lateinit var root: View
    lateinit var arrayListPoems: ArrayList<DataClassPoems>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        root = inflater.inflate(R.layout.fragment_home, container, false)

        var booleanAntiBag = true

        MyShare.init(requireActivity())
        arrayListPoems = ArrayList()
        arrayListPoems.addAll(MyShare.dataList!!)
        if (arrayListPoems.isEmpty()) {
            addDataToArrayList()
        }

        root.tv_hammasiSoni.text = arrayListPoems.size.toString()
        root.tv_saqlanganlarSoni.text = countSaqlanganlar().toString()

        root.card_barchasi.setOnClickListener {
            if (booleanAntiBag) {
                myFindNavController("Barcha")
                booleanAntiBag = false
            }
        }

        root.card_saqlanganlar.setOnClickListener {
            if (booleanAntiBag) {
                myFindNavController("Saqlangan")
                booleanAntiBag = false
            }
        }

        root.card_sevgiSherlari.setOnClickListener {
            if (booleanAntiBag) {
                myFindNavController("Sevgi va Sog'inch")
                booleanAntiBag = false
            }
        }

        root.card_soginchArmon.setOnClickListener {
            if (booleanAntiBag) {
                myFindNavController("Sevgi va Sog'inch")
                booleanAntiBag = false
            }
        }

        root.card_tabrikSherlari.setOnClickListener {
            if (booleanAntiBag) {
                myFindNavController("Tabrik")
                booleanAntiBag = false
            }
        }

        root.card_otaonaArmon.setOnClickListener {
            if(booleanAntiBag) {
                myFindNavController("Ota-Ona haqida")
                booleanAntiBag = false
            }
        }

        root.card_dostlikSherlari.setOnClickListener {
            if (booleanAntiBag) {
                myFindNavController("Do'stlik")
                booleanAntiBag = false
            }
        }

        root.card_hazilSherlar.setOnClickListener {
            if (booleanAntiBag) {
                myFindNavController("Hazil")
                booleanAntiBag = false
            }
        }

        root.image_add.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_thirdFragment)
        }

        return root
    }

    private fun myFindNavController(stringType: String) {
        Object.stringType = stringType
        findNavController().navigate(R.id.action_homeFragment_to_secondFragment)
    }

    private fun countSaqlanganlar(): Int {
        var int = 0
        for (i in arrayListPoems) {
            if (i.like) {
                int += 1
            }
        }
        return int
    }

    private fun addDataToArrayList() {
        arrayListPoems.add(DataClassPoems("Sevgi", "Mayliga orzular kulga aylansin\n" +
                "Yomg'ir tomchisidek do'lga aylansin.\n" +
                "Taqdir baxtimizni aylasin birga\n" +
                "Men seni sevishim chinga aylansin.", true, "Sevgi va Sog'inch" , arrayListPoems.size))
        arrayListPoems.add(DataClassPoems("Yomonman", "Hayolingiz band etgan bir hayolingizman,\n" +
                "\"Nega  seni sevdim?\" degan savolingizman.\n" +
                "Tuningizni yoritmagan hilolingizman.\n" +
                "Unutsangiz shod bòlguvchi bir YOMONMAN.\n" +
                "\n" +
                "Yomonman dedim kòp bora. Eshitmaysiz siz.\n" +
                "Aqlingiz bilan bir bora kelishmaysiz siz?!\n" +
                "Kurashmang. Men bilan baxtga erishmaysiz siz.\n" +
                "Unutsangiz xursand bòlar bir YOMONMAN.\n" +
                "\n" +
                "Qòl chozib ham yetmaydigan baxtingizman\n" +
                "Havolarda qolib ketgan ahdingizman.\n" +
                "Afsus. Sizning zoya ketgan vaqtingizman,\n" +
                "Unutsangiz xursand bòlar bir YOMONMAN.\n" +
                "\n" +
                "Mendan gòzalroq qiz toping, men roziman.\n" +
                "Har kun quchoğiga choping men roziman.\n" +
                "Baxtli bòlmasangiz sizdan noroziman.\n" +
                "Unutsangiz xursand bòlar bir YOMONMAN...", false, "Sevgi va Sog'inch", arrayListPoems.size))

        arrayListPoems.add(DataClassPoems("Tug'ulgan kun", "Qabul qiling mendan bir tilak, \n" +
                "Samimiy sözlar shirin bir istak. \n" +
                "Hayotingiz doim quvonchga to'lsin\n" +
                "Tug'ilgan kuningiz muborak bo'lsin.", false, "Tabrik", arrayListPoems.size))

        arrayListPoems.add(DataClassPoems("Tabrik", "ALLOHning sevimli bandasi" +
                "bõling, \n" +
                "Baxt va omad ila yuzlarga kiring, \n" +
                "Dunyolar saodati sizga bir tilak, \n" +
                "Tavallud kuningiz bo‘lsin muborak!!!", false, "Tabrik", arrayListPoems.size))

        arrayListPoems.add(DataClassPoems("Мусофир ўғлингдан рози бўл она",
            "Она она қўлинг ўпа олмадим, \n" +
                    "Сўнги йўлинга кузатопмадим. \n" +
                    "Бир сиқим тупроғинг тута олмадим, \n" +
                    "Мусофир ўғлингдан рози бўл она.\n" +
                    "\n" +
                    "Онажоним мехрибоним хоки соргинам,\n" +
                    "Тушларимга кириб туринг жаннатийгинам.\n" +
                    "Юз қулингиз ўпиб олай майли тушумда,\n" +
                    "Мусофир ўғлингнидан рози бўлинг она\n" +
                    "\n" +
                    "Қизим дедим ўғил дедим мени нима топдим,\n" +
                    "Онамаа мен сени арзонга сотдим.\n" +
                    "Бориб қабрингни қучоқлаб ётдим.\n" +
                    "Мусофир ўғлингни кечиргин она.",
            false,
            "Ota-Ona haqida", arrayListPoems.size))

        arrayListPoems.add(DataClassPoems("Musofir onangni kechir bolajon!",
            "Bilmadm taqdirmi yoki kamchilik,\n" +
                    "Majbur qildi meni kezishga jahon.\n" +
                    "Xavasmas senga ham axir yõqchilik,\n" +
                    "Musofir onangni kechir bolajon.\n" +
                    "\n" +
                    "Tunlari ertaklar aytib bermadim,\n" +
                    "Yoningda bolmadim sog'ingan zamon.\n" +
                    "Har kuni kutasan hanuz bormadim,\n" +
                    "Musofir onangni kechir bolajon.\n" +
                    "\n" +
                    "Menga ham orzumas uzoqda yurish,\n" +
                    "Sog'inchdan titraydi qalbim chalajon.\n" +
                    "Nasib etsin doimo yoningda bolish,\n" +
                    "Musofir onangni kechir bolajon.\n",
            false,
            "Ota-Ona haqida", arrayListPoems.size))

        arrayListPoems.add(DataClassPoems("Chin do'st", "Og'ir kunda tirgak do'st,\n" +
                "Havotirda sergak do'st,\n" +
                "100 ta dushman oldida,\n" +
                "Qochmas aslo erkak do'st!\n" +
                "\n" +
                "Dushmanlari ortganda,\n" +
                "Sohta do'stlar qochganda,\n" +
                "Barcha qo'lin tortganda,\n" +
                "Qo'lin cho'zar Chindan do'st!", false, "Do'stlik", arrayListPoems.size))

        arrayListPoems.add(DataClassPoems("Ayrim do'stlarga", "Siz ishoning burda noningiz,\n" +
                "Menga aslo-aslo kerakmas.\n" +
                "Siz yurgan yul butunlai boshka,\n" +
                "Sizning yulak bizning yulkmas.\n" +
                "\n" +
                "Dunyonngizga ҳech ҳam siғmayman,\n" +
                "Laychilikni kilmayman ҳavas.\n" +
                "Dustni sotish nedur bilmayman,\n" +
                "gyibatchini mizhozim suimas.", false, "Do'stlik", arrayListPoems.size))

        arrayListPoems.add(DataClassPoems("Shaxarlik qizlar",
            "O'qishda kursdoshim Oydin ustidan. \n" +
                    "Kulishdi birnechta shaxarlik g'alcha. \n" +
                    "Yupka kiyip kepti shimni ustidan. \n" +
                    "Boots o'ziga kattamush ancha. \n" +
                    "\n" +
                    "Shaxarlik qizlarga savollarim bor. \n" +
                    "Javob berib ko'ring kelmasa malol. \n" +
                    "Saxarda ko'chaga suvlarni sepib. \n" +
                    "Dalaga chiqqanmisiz, boqish uchun mol. \n" +
                    "\n" +
                    "Tandir oqarishi siz uchun nima? \n" +
                    "Non yopkanmisiz xo'roz uyg'onmay. \n" +
                    "Sandalda qo'lizga ovolib igna. \n" +
                    "Do'ppi tikkanmisiz sham yorug'ida? \n",
            false,
            "Hazil", arrayListPoems.size))

        arrayListPoems.add(DataClassPoems("Ahmad boy", "Bugun shov - shuv har yoqda.\n" +
                "Eshitingizmi hoy-hoy?\n" +
                "Nima bo'ldi aytingchi!\n" +
                "Qamalibdi Ahmad boy!\n" +
                "\n" +
                "Sog' odamlar shol bo'ldi\n" +
                "Yosh yigitlar chol bo'ldi\n" +
                "Butun dunyo lol bo'ldi\n" +
                "Qamalibdi Ahmad boy !\n" +
                "\n" +
                "Bo'laman deb paxmoq boy\n" +
                "Bo'lib qoldi axmoq boy\n" +
                "Ko'pchilikka ko'rgulik\n" +
                "Qamalibdi Ahmad boy !\n" +
                "\n" +
                "Besh so'mini o'n qilib\n" +
                "Deyishgandi raxmat boy\n" +
                "Bugun padarin so'kar\n" +
                "Qamalibdi Ahmad boy !\n", false, "Hazil", arrayListPoems.size))

        MyShare.dataList = arrayListPoems
    }

}