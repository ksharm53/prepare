package july;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MatchNames {

	public static void main(String[] args) {
		List<String> inputNames = List.of("Sherce Splin", "Bernic Pasmore", "Tori Brodnay", "Glen Kalec",
				"Lydia Bowens");
		List<String> dmvRecords = List.of("Courtney Mackstutis;4766 Moctezuma", "Angela Gimbel;1270 Finazzo",
				"Hector Koba;7074 Turrill", "Jonell Fujiwara;5382 Leabow", "Magdalena Purce;9215 Jungbluth",
				"Marvella Zabala;8477 Winterroth", "Milda Rovella;9943 Lofing", "Cristin Downing;6136 Johal",
				"Sonny Alterio;6068 Beaudette", "Kathryne Bregantini;9160 Hammes", "Hermila Crume;8297 Ailsworth",
				"Meg Mungle;4604 Florida", "Carin Scieszka;5809 Sammarco", "Fatima Datz;3187 Lagnese",
				"Lanette Gammon;2410 Soliday", "Evangeline Scheidecker;5136 Malett", "Shaneka Corlee;8382 Pinal",
				"Eleonora Hagood;9782 Mccarroll", "Queen Tousom;4079 Bansmer", "Issac Yeldon;7979 Agustin",
				"Herma Almsteadt;1916 Forest", "Alease Duryea;9910 Breault", "Mark Christen;3279 Viereck",
				"Tijuana Buckless;7910 Berlinghof", "Sasha Burrel;1622 Voitier", "Davina Basone;7715 Hamberger",
				"Shayla Grubb;9190 Kubat", "Marcelo Salgado;6947 Campolongo", "Francis Lebel;8772 Bowdle",
				"Leigha Gielow;7689 Lehtinen", "Steve Burhanuddin;1870 Sias", "Lesley Roblodowski;6707 Mckinstry",
				"Dorinda Loveall;5330 Burson", "Prudence Gleaton;6741 Emhoff", "Jame Dolhon;1689 Shoffstall",
				"Tad Horsley;2400 Dragna", "Chasidy Lebert;1127 Sadak", "Daryl Umphlett;7842 Nooman",
				"Chloe Shazier;2828 Pherguson", "Abbey Samele;1784 Searfoss", "Lonnie Pfahlert;2809 Hanshew",
				"Jae Krallman;8206 Ysquierdo", "Bernadine Quince;3229 Wehrle", "Noelle Ridgway;1284 Calamari",
				"Sharri Biagioni;3013 Kniola", "Glenn Kadlec;1088 Xia", "Harley Bieberle;4185 Striker",
				"Felicia Vitelli;6588 Sowl", "Dan Amazan;9841 Wasicek", "Tandy Macia;6419 Koiner",
				"Laverne Kowall;6750 Drugan", "Bennie Jermeland;2478 Hausteen", "Belen Korman;4202 Seed",
				"Blanca Warnke;1084 Migneault", "Hilma Kellems;6508 Zalamea", "Tiffanie Juve;9206 Bried",
				"Lester Kann;6325 Wehunt", "Riley Barchus;6475 Townley", "Patrica Chary;4823 Reynolds",
				"Bianca Riedesel;6763 Rienstra", "Hilde Warzybok;5917 Shasky", "Heike Cesari;2472 Kirbo",
				"Layla Lentsch;4502 Haner", "Benita Livshits;987 Danella", "Dexter Betit;6081 Pollinger",
				"Mirella Cockrin;2199 Mguyen", "Randall Spiegel;4747 Stolinski", "Sonja Billen;905 Brzycki",
				"Tiffani Lichty;3843 Apodaca", "Diamond Norquest;8664 Bonda", "Wyatt Longinotti;940 Woolcock",
				"Joe Dupoux;3631 Condell", "Raven Beyerlein;3626 Sandlian", "Duane Shiever;5510 Cliatt",
				"Olga Cataquet;3440 Whigum", "Miquel Lenkiewicz;9256 Gautney", "Grazyna Valsin;7570 Hartquist",
				"Monty Huron;807 Trisler", "Corinna Iannalo;637 Kinaj", "Roscoe Leppke;2783 Holste",
				"Rubie Anelli;2774 Regler", "Lino Goldsmith;9435 Streets", "George Martiarena;6271 Piwetz",
				"Onie Messa;2703 Yim", "Dawn Stonier;2106 Meltz", "Lynne Backhuus;8769 Fortes",
				"Leilani Greenmyer;1229 Goodfellow", "Lizzie Woznicki;8813 Bunten", "Eliza Erling;5479 Kiehne",
				"Joelle Haymore;2536 Curington", "Janean Weidman;7037 Keefe", "Kam Lupacchino;9330 Hunte",
				"Verdell Cavaco;3113 Mitch", "Cortney Smarsh;9955 Stewardson", "Teresa Cichosz;9153 Niess",
				"Otha Coppa;9796 Mischo", "Vinita Grzebien;1953 Davignon", "Hilma Traw;7698 Corujo",
				"Arnulfo Jaquith;9956 Pesina", "Randi Panetta;3282 Aholt", "Lucilla Bisping;9896 Crea",
				"Kandra Mulcahy;8028 Duplechin", "Cristopher Carsey;9767 Doucet", "Estell Whirley;5009 Gaskill",
				"Shirlee Mckevitt;9025 Lewey", "Stephane Kokko;2331 Ferran", "Sherice Salazak;1572 Jurisch",
				"Janeen Dayan;9329 Langshaw", "Julee Bahri;1658 Cassiano", "Rocky Thurmond;665 Carualho",
				"Audrie Engelken;2327 Grix", "Stasia Muraoka;4034 Buquo", "Sherwood Parilla;898 Vier",
				"Xuan Lefaver;2081 Brouwer", "Eddy Prevento;9375 Badeau", "Jules Correa;8790 Sagen",
				"Albertine Chisman;9633 Lenoue", "Kassandra Kahley;1886 Schachter", "Aline Ludington;9466 Neang",
				"Eddie Plona;6353 Dandrow", "Sheryl Nowland;4814 Schoolcraft", "Arlette Quispe;9034 Slaughenhoupt",
				"Cyril Scandrett;8536 Guadalupe", "Particia Finner;240 Fielder", "Myron Mines;2300 Ehleiter",
				"Keren Derrico;7569 Chio", "Adrien Vo;2841 Wombacher", "Felisha Holsinger;5285 Quispe",
				"Mia Niau;9477 Romm", "Rochell Winslett;8296 Hasley", "Tracey Breslin;549 Johnso",
				"Odell Marquette;4295 Valenza", "Lizabeth Swails;1898 Swoffer", "Carolann Marrapese;1595 Mylar",
				"Beula Arviso;5334 Kram", "Luisa Garr;4946 Penunuri", "Dusti Casher;5317 Gaucin",
				"Earnest Dender;3481 Huyser", "Pok Ahmad;4774 Lawcewicz", "Caitlin Sibbett;2457 Vanbergen",
				"Kyong Simoes;5469 Kimbley", "Evette Vondoloski;9348 Pfleuger", "Santos Faxon;5644 Macdonell",
				"Carlena Mceachron;5798 Magnall", "Hester Saide;9945 Dycus", "Dianna Kumar;4873 Luttman",
				"Vickie Allenbach;3141 Wools", "Rudy Sirhan;9283 Mickelberry", "Brunilda Clendening;3756 Papadakis",
				"Janett Sprinkel;4776 Fazio", "Hester Aemmer;2429 Rosendo", "Bethann Sherretts;3568 Graveline",
				"Sam Melchiori;1535 Bennes", "Chantelle Supplice;4901 Lewars", "Monserrate Rinaudo;1147 Griswould",
				"Dina Mckelphin;7191 Bail", "Candace Blalack;6416 Wintermute", "Jame Machen;3305 Deckman",
				"Coleen Simmoms;1354 Fleisner", "Damian Sholl;1845 Lovecchio", "Freida Erhard;7695 Gambill",
				"Galen Blasetti;3318 Siddiq", "Dirk Sauter;5794 Desanctis", "Kerry Dahood;550 Riche",
				"Otha Ladell;4281 Camano", "Maragaret Kutlu;6409 Tecchio", "Jefferey Heinitz;3770 Vandertuig",
				"Salome Cwiek;1842 Yoshina", "Jamey Saniatan;6479 Bagwill", "Reagan Ezell;1352 Gwozdz",
				"Savanna Agron;2089 Setting", "Sherice Buchann;477 Schoeman", "Latasha Behm;3998 Giannotti",
				"Cinderella Almonte;8376 Wujcik", "Marna Birckett;5583 Crafton", "Shameka Checketts;1634 Heisser",
				"Zenaida Wayns;5068 Byland", "Charlesetta Scheffrahn;2560 Difillippo",
				"Renee Vanderstappen;8693 Difalco", "Earl Rosette;7010 Belling", "Lizbeth Forsting;5438 Maresca",
				"Yolanda Pyscher;9747 Schools", "Mariano Chandrasekhar;564 Lamport", "Kanisha Doniel;4951 Roerig",
				"Florene Torreblanca;4932 Hankerson", "Marquetta Salgado;1151 Smiley", "Deborah Czarniecki;7469 Chasey",
				"Chung Grum;3153 Zarzuela", "Douglass Wales;672 Runquist", "Laquanda Huelskamp;4563 Cavener",
				"Bulah Mainguy;9295 Heiler", "Annika Bedenfield;9877 Talsma", "Julian Sherbo;6232 Schnarr",
				"Clarissa Thorn;9824 Tyrol", "Hipolito Prast;8692 Anzualda", "Chas Moscardelli;7542 Lunden",
				"Tierra Pal;992 Yafei", "Maryanne Erazo;4159 Spindola", "Patricia Adjutant;1461 Daymude",
				"Lucila Botellio;4120 Dorsinville", "Leandra Auvil;6979 Sacher", "Roselia Factor;1090 Evens",
				"Nga Bursi;5614 Hua", "Leeanne Riveron;6936 Sturtevant", "Alexis Moselle;5748 Shreeve",
				"Xenia Prugh;1331 Bester", "Estell Kroschel;8311 Moerman", "Allie Konopnicki;9739 Eyles",
				"Lorie Hoffses;1659 Corsini", "Roland Mayzes;7613 Beserra", "Violet Amarian;1629 Ryle",
				"Kizzie Devit;6943 Francesconi", "Lisa Cuch;9255 Kuchta", "Caroyln Silveria;8199 Crutsinger",
				"Petronila Touma;7243 Hugi", "Darrel Ju;3006 Coxon", "Francesco Vielle;6730 Uphold",
				"Celine Sarcone;9679 Scroger", "Maia Holthouse;8854 Ailsworth", "Carlee Modha;7990 Lossa",
				"Cassie Moury;3020 Veltman", "Alverta Radabaugh;9898 Marxen", "Sandy Mccier;3002 Secrist",
				"Oma Mcmurdie;4821 Elshair", "Shannan Helin;2032 Sarmento", "Jody Gentille;661 Strahl",
				"Marti Requena;2355 Platzer", "Ewa Amento;5769 Tremmel", "Talia Soprych;7243 Kevern",
				"Earl Hussein;7818 Oyabu", "Jacques Mccarns;9574 Meer", "Gay Popoca;3937 Blakney",
				"Jeni Coyier;4709 Helmink", "Cierra Demaranville;4903 Gazzillo", "Jesus Mithcell;7435 Breer",
				"Felicitas Gahagan;8518 Mazin", "Anjelica Acampora;7229 Svob", "Berta Plotts;3313 Arif",
				"Merissa Mcconathy;7969 Sprafka", "Joi Borok;4852 Smeby", "Delta Tisdel;4473 Goldinger",
				"Elli Sehrt;7896 Ronco", "Danika Mooers;4655 Klenovich", "Margarete Latzke;2911 Ragain",
				"Pam Gianunzio;6208 Ichinose", "Ariel Gaugler;3637 Smiler", "Dwayne Laureles;3260 Gerstenberger",
				"Keli Malanaphy;5574 Orizetti", "Ed Cuadro;9578 Zuerlein", "Josiah Macafee;9213 Sabo",
				"Bernice Passmore;1354 Fehrle", "Olinda Dovey;3587 Mcgrew", "Gilda Kortge;8804 Ewig",
				"Madie Vanwyk;3286 Sugai", "Raymundo Bliler;6988 Sitkiewicz", "Antonina Hennegan;1257 Lincicome",
				"Abigail Neris;2049 Goffredo", "Alonzo Swiger;6052 Dushaj", "Xiomara Ramariz;6243 Leshko",
				"Maynard Tonelli;6136 Belveal", "Sara Durig;910 Xiao", "Edmond Zourkos;8852 Degregorio",
				"Shanelle Kabzinski;3733 Lagant", "Madelene Knocke;5608 March", "America Guilbault;7190 Neilsen",
				"Miesha Mcclatchey;2082 Dyron", "Jannette Philips;6870 Ostermeyer", "Renata Inabnit;3709 Remondet",
				"Horacio Whitsitt;8842 Joun", "Sari Podsiad;4453 Brooke", "Ivory Setting;8114 Yaden",
				"Lynwood Aldape;9399 Corburn", "Sanjuanita Hegland;2415 Dufrane", "Kathie Deprospero;8163 Cummisky",
				"Elia Sabado;269 Triffo", "Akiko Everline;9468 Urrabazo", "Margaret Sniff;5825 Ahl",
				"Tera Vina;6118 Danielian", "Aura Farfan;1572 Chiumento", "Leora Schrupp;2322 Lalich",
				"Natisha Piskura;8735 Whisby", "Frankie Fabbri;1145 Jeannette", "Nu Donilon;764 Engholm",
				"Kina Raymundo;2445 Gochie", "Jewel Cleveland;5253 Giroux", "Sherice Splain;9669 Waples",
				"Rosenda Barbini;450 Medora", "Nevada Sickels;9619 Lackie", "Tisa Petko;5881 Hammerle",
				"Leandro Sanroman;3464 Rolfs", "Giuseppe Ribsamen;5239 Labrec", "Tosha Macall;8157 Helper",
				"Soraya Brightful;8386 Cloughly", "Iluminada Susany;4580 Cabriales", "Kristyn Slicker;1252 Dupouy",
				"Curtis Rush;1869 Itnyre", "Danna Lencioni;366 Nutall", "Bobbie Boetcher;9789 Alexion",
				"Marianela Rogillio;1810 Bendickson", "Breana Deon;3148 Pastor", "Sanford Shider;6715 Pecher",
				"Ronnie Pattison;8830 Graces", "Colin Tonas;2889 Ayers", "Vonnie Casamento;7261 Larison",
				"Colene Weimann;7478 Ramella", "Carolin Simmonds;1030 Sholl", "Sierra Stassi;4046 Mcglinn",
				"Idell Lopriore;7135 Van", "Estella Gosney;3309 Puccia", "Alaine Readinger;4876 Martorell",
				"Loria Agler;2381 Box", "Terra Hirano;4170 Neuhauser", "Rosetta Danford;7269 Petruccelli",
				"Caitlin Kubala;1138 Fixico", "Kandra Mcclinsey;2910 Vaksman", "Madison Mantia;1834 Lefaver",
				"Rosalyn Raid;7080 Bagan", "Dominque Lunday;2306 Ivanov", "Jeffrey Moitoza;3959 Fereday",
				"Jona Barbosa;4864 Razor", "Marita Wallberg;968 Wignall", "Cleta Lafield;7797 Reaver",
				"Renay Erard;1017 Disanto", "Freddy Staton;5429 Mires", "Qiana Gummersall;2782 Hender",
				"Alpha Edelmann;8463 Santomauro", "Anya Lanclos;8294 Kottwitz", "Hannah Boulet;718 Ourso",
				"Alyce Vannah;4983 Dazzi", "Shakita Jungbluth;3225 Altsisi", "Dorethea Swauger;5228 Burrer",
				"Bibi Moorman;799 Lacaille", "Janice Caveney;4746 Andrzejewski", "Corie Cusic;9796 Natera",
				"Chanel Smallen;5639 Stoeffler", "Devorah Chilo;9751 Roszel", "Kathern Margison;9434 Older",
				"Rufus Whetsel;3481 Vanheel", "Hortensia Marcelle;7157 Wage", "Lorrine Wisnowski;6337 Tuman",
				"Priscila Chipp;7430 Fulkerson", "Lana Brockelmeyer;5100 Worsell", "Ira Lenning;4599 Azapinto",
				"Karl Frerichs;2808 Mclauren", "Javier Gerig;9693 Flis", "Mirian Romaniszyn;3895 Enmon",
				"Loren Enno;158 Lichorat", "Shanda Gergen;2452 Soohoo", "Ramona Shetrawski;5693 Snodderly",
				"Jada Biggs;5990 Cay", "Rachel Forkell;5688 Lofquist", "Mayme Anauo;5230 Walper",
				"Daphine Neace;1821 Maroun", "Carylon Teagues;6890 Jacks", "Nathalie Murton;2464 Yovanovich");

		System.out.println(solve(inputNames, dmvRecords));

	}

	private static List<String> solve(List<String> inputNames, List<String> dmvRecords) {
		List<String> result = new ArrayList<>();
		Map<String, String> map = convertToMap(dmvRecords);

		for (String eachInput : inputNames) {
			String fName = eachInput.split(" ")[0];
			String lName = eachInput.split(" ")[1];
			if (map.containsKey(eachInput.toLowerCase())) {
				result.add(map.get(eachInput.toLowerCase()));
			} else {
				for (Entry<String, String> eachEntry : map.entrySet()) {
					String firstName = eachEntry.getKey().split(" ")[0];
					String lastName = eachEntry.getKey().split(" ")[1];

					int fnameValidate = validateMisSpelling(fName.toLowerCase(), firstName.toLowerCase());
					int lastNameValidate = validateMisSpelling(lName.toLowerCase(), lastName.toLowerCase());

					if ((fnameValidate + lastNameValidate) == 1) {
						result.add(eachEntry.getValue());
						break;
					}
				}
			}
		}

		return result;

	}

	private static int validateMisSpelling(String eachMapEntry, String eachInput) {
		int len1 = eachMapEntry.length();
		int len2 = eachInput.length();

		int[][] matrix = new int[2][len1 + 1];

		for (int i = 0; i <= len1; i++) {
			matrix[0][i] = i;
		}

		for (int i = 1; i <= len2; i++) {
			for (int j = 0; j <= len1; j++) {
				if (j == 0) {
					matrix[i % 2][j] = i;
				} else if (eachMapEntry.charAt(j - 1) == eachInput.charAt(i - 1)) {
					matrix[i % 2][j] = matrix[(i - 1) % 2][j - 1];
				} else {
					matrix[i % 2][j] = 1 + Math.min(matrix[(i - 1) % 2][j],
							Math.min(matrix[i % 2][j - 1], matrix[(i - 1) % 2][j - 1]));
				}
			}
		}

		return matrix[len2 % 2][len1];
	}

	private static Map<String, String> convertToMap(List<String> dmvRecords) {
		Map<String, String> map = new HashMap<>();
		for (String eachRecord : dmvRecords) {
			String[] val = eachRecord.split(";");
			map.put(val[0].toLowerCase(), val[1]);
		}

		return map;

	}

}
