package oct2023;

import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

public class ReductionOperations {

	public static void main(String[] args) {
		int[] nums = { 7124, 39569, 10243, 16528, 7935, 13264, 2902, 44928, 45045, 8993, 34133, 49180, 41310, 38195,
				49936, 44670, 41395, 47162, 44414, 29721, 48286, 42023, 36473, 7552, 35392, 36613, 49741, 16195, 11644,
				27369, 27642, 39325, 10870, 2621, 21510, 45266, 820, 21023, 49491, 46539, 11161, 9679, 24146, 16183,
				43322, 38178, 2754, 46762, 47729, 27444, 43008, 10244, 21393, 38417, 14042, 40999, 15968, 31532, 18460,
				17681, 38399, 42104, 33987, 33116, 46901, 37212, 49444, 32862, 31608, 14667, 49350, 49528, 10617, 46481,
				4312, 37059, 16347, 29807, 9094, 24648, 11017, 1347, 45694, 6164, 48370, 3737, 2240, 36767, 3614, 40122,
				32643, 49350, 30427, 47564, 1586, 32270, 17198, 18570, 18077, 47881, 24984, 31375, 7805, 5753, 20362,
				41354, 24721, 28530, 12902, 15413, 34550, 10071, 4523, 45412, 47078, 47574, 18953, 13523, 6638, 22917,
				17645, 8968, 14494, 23459, 23040, 10443, 48653, 6799, 6866, 47944, 12892, 19889, 15431, 41546, 4296,
				2703, 21783, 39455, 47975, 24732, 13987, 23922, 40031, 44872, 46303, 5028, 49588, 30082, 30655, 21759,
				44739, 19175, 21779, 44586, 34206, 1253, 33442, 5644, 8446, 10846, 1323, 1730, 16242, 13390, 49246,
				45928, 44782, 47777, 47715, 28309, 20291, 41914, 12135, 6996, 24619, 34479, 34381, 586, 40122, 12916,
				4380, 14318, 10472, 20521, 13358, 47492, 20757, 15024, 17183, 22759, 25696, 47032, 20816, 3203, 29833,
				13109, 49445, 44671, 7192, 30226, 10187, 25537, 24709, 13597, 20567, 22234, 15602, 32496, 30596, 26144,
				47749, 285, 30543, 23054, 42156, 41522, 31543, 22105, 3587, 29015, 25728, 44322, 39866, 45664, 38007,
				44087, 31178, 31984, 46405, 45050, 18850, 3938, 32953, 30319, 15198, 6130, 42143, 19828, 42446, 10687,
				29555, 13834, 17523, 10666, 35496, 19839, 47518, 25705, 446, 12338, 37020, 39205, 31459, 897, 19197,
				41610, 48606, 17400, 36318, 17016, 5054, 49424, 25584, 3053, 37340, 36209, 45768, 2516, 12861, 45580,
				31006, 49961, 14174, 25866, 21208, 19594, 31916, 40869, 33554, 16789, 46532, 17277, 39523, 10542, 25964,
				26486, 32756, 36495, 14787, 15427, 26646, 39173, 29292, 4917, 46888, 49982, 25378, 3693, 91, 45243,
				12446, 23073, 12917, 6920, 45734, 2467, 30922, 12518, 3562, 43846, 11706, 20692, 2804, 43870, 33122,
				16752, 13513, 12514, 26727, 34514, 4255, 37605, 11771, 16758, 2956, 9529, 904, 47050, 49648, 3873,
				38792, 36323, 14139, 49104, 11474, 21478, 9181, 11299, 45076, 26479, 37975, 77, 183, 38018, 21827,
				33160, 42375, 49900, 1749, 14105, 5227, 48446, 31592, 30408, 4856, 11194, 17682, 34013, 1206, 27133,
				19092, 38215, 36721, 38299, 13127, 11877, 20951, 6439, 47674, 37637, 19079, 46375, 19879, 13136, 37036,
				33998, 7301, 807, 18379, 13601, 14188, 49737, 15423, 35533, 13016, 32663, 20813, 26152, 39598, 31588,
				47466, 6858, 24351, 4917, 30518, 16532, 31171, 48029, 3914, 1322, 21792, 31359, 45341, 694, 16156,
				36045, 8229, 3231, 25861, 6301, 15172, 3462, 19650, 40380, 24245, 6728, 6319, 18065, 18399, 47184,
				10047, 15426, 35325, 48768, 39723, 10226, 31293, 3657, 26992, 28846, 46881, 1976, 801, 21697, 40991,
				28473, 19546, 31984, 3388, 47267, 28917, 20862, 27856, 41249, 1672, 11047, 18407, 23771, 15767, 4445,
				9495, 40114, 45716, 20934, 25902, 35479, 35518, 38325, 46087, 20288, 49535, 34778, 21132, 24053, 31982,
				9234, 40364, 13732, 27273, 14102, 6791, 49312, 5315, 11256, 963, 41617, 1399, 5430, 29766, 34613, 37333,
				4813, 12168, 23534, 34559, 36448, 41391, 11357, 12020, 48260, 27305, 4966, 30285, 7118, 175, 31570,
				42399, 23913, 26460, 48003, 9430, 38263, 23844, 9118, 39217, 15510, 25533, 21393, 12374, 34780, 41598,
				34959, 6533, 20228, 28858, 13548, 38002, 44955, 29746, 9959, 16790, 3511, 10719, 12872, 45626, 32179,
				35338, 12927, 2786, 26178, 41243, 22592, 31311, 33222, 27223, 14505, 12745, 40992, 5265, 1024, 10201,
				32440, 39535, 47060, 14134, 32564, 17628, 25796, 8097, 33149, 4581, 6423, 22735, 11056, 13033, 44880,
				28017, 20302, 26829, 16896, 34055, 41482, 16078, 24714, 26729, 2239, 2617, 49127, 47501, 12612, 24393,
				26581, 21096, 26857, 18113, 29627, 46447, 25674, 11510, 8436, 45590, 28199, 22887, 46140, 44470, 23983,
				37918, 24461, 32790, 28498, 2256, 24113, 49665, 8099, 21892, 3514, 13946, 48780, 40168, 23473, 11716,
				36471, 49907, 38271, 47655, 18783, 32706, 36679, 11397, 27725, 24156, 24335, 1993, 10928, 11999, 40189,
				23529, 45169, 46000, 30805, 41038, 29241, 44827, 35396, 12589, 8032, 21033, 42998, 48716, 1075, 28082,
				14580, 28770, 20226, 27537, 18066, 5211, 36480, 13011, 29669, 7320, 41845, 2509, 45457, 312, 34910,
				37547, 14689, 15701, 2085, 39622, 32657, 43904, 21743, 13424, 12494, 7290, 1870, 45489, 49952, 19618,
				40968, 18395, 45979, 6193, 8742, 24292, 29489, 27775, 21584, 49276, 46962, 4067, 33296, 19911, 5503,
				30400, 14590, 10446, 37078, 37937, 38402, 13750, 34306, 19171, 49451, 38571, 42962, 37575, 30789, 18789,
				44582, 18381, 6483, 36144, 42672, 16636, 10563, 11636, 34494, 49107, 38938, 10909, 28114, 45323, 19790,
				26032, 26092, 15199, 10977, 27004, 11238, 36837, 35573, 21640, 15994, 14266, 9757, 18854, 46114, 43965,
				4906, 41538, 4939, 45287, 15685, 7555, 42497, 19984, 49266, 697, 8648, 26599, 25927, 41533, 3691, 8176,
				39491, 3448, 8637, 30499, 25877, 19145, 15625, 10423, 30845, 15341, 41761, 38294, 14761, 39695, 16468,
				34319, 27392, 30181, 37981, 36923, 46048, 18444, 8661, 41719, 43185, 33620, 8459, 2120, 8568, 41568,
				34882, 10096, 38281, 617, 33978, 16573, 35778, 35966, 11407, 47061, 2249, 22724, 31517, 35765, 40106,
				12219, 15190, 21327, 42569, 49566, 41564, 12090, 46319, 13831, 44254, 11299, 37074, 32318, 43468, 48343,
				16215, 8217, 13691, 3064, 33698, 21930, 16172, 26500, 29963, 47061, 17367, 46700, 11941, 7674, 2889,
				5699, 2383, 18758, 32646, 3299, 7881, 41292, 20450, 39440, 24318, 22659, 15667, 13881, 16811, 12451,
				10627, 22263, 18275, 43224, 48378, 21184, 23748, 2427, 5115, 13971, 11363, 25810, 42315, 30012, 13748,
				40677, 811, 30368, 25985, 24771, 22836, 45044, 24318, 32281, 39312, 39457, 545, 42456, 16531, 49142,
				5067, 43426, 3822, 26505, 26666, 24494, 46254, 26281, 12115, 19965, 41852, 12801, 40231, 5888, 19918,
				1937, 27831, 2543, 30005, 378, 26456, 13299, 35731, 40234, 31200, 16792, 1553, 39216, 45551, 48848,
				13726, 14638, 44843, 42805, 9119, 39214, 45996, 21713, 15686, 41235, 17251, 21710, 2337, 25243, 19003,
				1140, 41397, 30668, 1692, 27864, 1036, 7168, 11349, 43407, 16272, 1225, 26526, 39801, 29154, 10070,
				5047, 14074, 12515, 49793, 27323, 36874, 37731, 45560, 23460, 24079, 4098, 47280, 14436, 12880, 6164,
				8361, 39502, 18142, 22731, 46277, 49076, 21472, 27821, 17285, 27033, 23296, 43284, 14937, 4910, 29791,
				14351, 41306, 18113, 41493, 674, 33364, 39281, 20880, 12399, 23540, 37623, 44323, 19937, 24527, 45941,
				12927, 43347, 22999, 21152, 36229, 35945, 17561, 26665, 5873, 24708, 12492, 48294, 29411, 47693, 37841,
				12902, 14188, 21332, 31395, 28786, 326, 3168, 19648, 8278, 33471, 25513, 4653, 19247, 36304, 38126,
				8402, 21139, 21111, 25311, 31178, 41286, 43883, 36988, 9572, 16846, 14402, 16152, 24709, 46595, 37370,
				24153, 40310, 40454, 35108, 49021, 3278, 19751, 30352, 33137, 45813, 22559, 42285, 343, 9792, 31204,
				32648, 49773, 1258, 2130, 25625, 42929, 45384, 28552, 48145, 7052, 13432, 44875, 27844, 47126, 24370,
				28229, 29530, 25186, 27852, 4125, 32716, 11955, 33652, 45051, 14020, 12181, 6529, 47946, 27832, 23677,
				14409, 11789, 25242, 45526, 38255, 23295, 46621, 39202, 24245, 9256, 35205, 43586, 10436, 15311, 16818,
				36066, 16212, 42569, 4687, 5197, 13265, 36893, 28640, 32255, 49929, 2511, 21068, 14423, 4919, 28158,
				5532, 20927, 11944, 31302, 15450, 23192, 48585, 38779, 37536, 13041, 18564, 10962, 29683, 47307, 49220,
				7368, 44655, 1847, 6700, 16631, 34979, 20001, 6771, 47127, 18622, 13276, 30330, 47710, 14728, 48537,
				1868, 27225, 4851, 22273, 30502, 29616, 29602, 36664, 41975, 14646, 28339, 18101, 24877, 39279, 5711,
				37661, 26165, 43368, 25993, 6552, 6839, 23903, 23142, 23011, 25968, 31237, 31914, 13495, 42170, 14118,
				9241, 13568, 7595, 48199, 910, 37589, 47103, 12071, 31916, 22528, 16502, 20376, 5861, 13768, 45634,
				40857, 35933, 9237, 43234, 16565, 46628, 15629, 6275, 37312, 19599, 34273, 27287, 21099, 37889, 36404,
				23375, 10167, 34329, 30095, 33128, 14928, 42023, 20501, 13599, 36303, 48735, 21545, 8411, 35592, 9017,
				25903, 47097, 18466, 2427, 1921, 46632, 2252, 26658, 24050, 2795, 32868, 30231, 37892, 47507, 44910,
				29868, 41713, 33042, 19396, 35644, 26174, 26486, 44386, 49198, 21660, 16600, 31915, 5237, 1316, 9804,
				20706, 4239, 42992, 23589, 3584, 3970, 41756, 25133, 21102, 14150, 9104, 28083, 15317, 18572, 22327,
				319, 14740, 13943, 17370, 26508, 19709, 30833, 26575, 31957, 38943, 30548, 17296, 1108, 30563, 29391,
				29813, 34594, 27920, 49143, 40811, 14287, 39059, 23993, 41714, 28665, 11146, 11425, 43037, 37117, 29960,
				36192, 23198, 40818, 34062, 1509, 14101, 48980, 7267, 24484, 47646, 2640, 42646, 46368, 29406, 4269,
				21321, 41172, 6357, 5968, 34042, 23947, 14983, 45984, 5941, 21805, 8455, 15945, 23038, 15364, 17532,
				16069, 33393, 25607, 38068, 2397, 946, 17043, 47528, 18353, 32668, 7623, 31878, 43983, 26999, 18340,
				6343, 4045, 22543, 31980, 24077, 35181, 39391, 17326, 13145, 28082, 47532, 25083, 11134, 37143, 49227,
				42622, 24166, 4577, 36850, 29184, 18476, 30787, 48720, 24129, 13241, 21629, 25213, 24179, 11167, 29181,
				23735, 16432, 35764, 47262, 8379, 14508, 48761, 10455, 21782, 43580, 46905, 149, 8140, 9099, 13179,
				8615, 36669, 33188, 3272, 25026, 49651, 9202, 8490, 22262, 30961, 30454, 6292, 1032, 25487, 9590, 24843,
				5650, 48943, 39601, 8737, 5592, 33377, 17051, 19432, 9909, 37684, 47856, 48531, 21877, 44958, 46635,
				6591, 37904, 29039, 5615, 33366, 42654, 804, 12660, 34410, 23577, 45331, 28800, 7503, 12369, 1126,
				38425, 1612, 44836, 36430, 6846, 19974, 41368, 44475, 1404, 27313, 42800, 36093, 11304, 35415, 39174,
				39110, 17150, 47139, 11535, 3063, 1507, 36942, 12388, 12323, 11334, 47841, 46830, 7921, 41691, 23555,
				3153, 43422, 46550, 43288, 43426, 20231, 7243, 39115, 10972, 14183, 8, 3309, 15306, 11247, 27644, 37427,
				15343, 9256, 321, 33511, 30624, 32236, 2071, 9669, 32670, 16710, 30439, 36799, 45545, 23326, 38495,
				22165, 39799, 43518, 30354, 27294, 15478, 48851, 24460, 30537, 31422, 32389, 431, 12298, 21787, 12559,
				6559, 21949, 30549, 2950, 45334, 12231, 17126, 44607, 35902, 15928, 29352, 47084, 28341, 8386, 11278,
				38759, 2594, 33435, 37348, 20504, 31671, 48552, 44029, 46058, 19533, 36183, 16698, 18184, 34681, 32830,
				24704, 16038, 34215, 14676, 22500, 20221, 18128, 37415, 20896, 37773, 24951, 17128, 15928, 39241, 40297,
				5449, 42952, 32506, 10853, 49926, 24418, 36046, 44003, 37737, 10443, 35453, 39192, 5350, 28957, 31253,
				44962, 23860, 20824, 4907, 35179, 33933, 14166, 14552, 43634, 45369, 9587, 23265, 22469, 35412, 33848,
				33541, 35741, 11243, 10870, 41636, 49866, 12547, 38448, 13407, 13529, 35432, 2074, 37211, 41677, 27174,
				12323, 30116, 26892, 21696, 44550, 1893, 20691, 11742, 8267, 15164, 27421, 36307, 31917, 11349, 33367,
				7747, 8162, 38229, 6430, 1056, 40581, 30542, 11687, 5480, 35762, 5780, 9168, 45809, 845, 26751, 18222,
				12488, 22629, 42806, 28745, 41694, 32045, 30384, 39391, 32361, 30642, 41394, 37522, 17148, 6701, 22057,
				22311, 4161, 29923, 37123, 44755, 25412, 18375, 25843, 21732, 4464, 19813, 8975, 17009, 42668, 43821,
				1308, 9624, 11821, 12274, 40560, 25068, 8183, 16223, 26464, 11196, 46840, 19136, 22676, 40657, 34655,
				8415, 26088, 7550, 40323, 24927, 23754, 14961, 858, 6675, 13935, 45076, 49626, 25001, 5129, 1906, 37367,
				24055, 23218, 25320, 7621, 9086, 40211, 49183, 10863, 14215, 13756, 30518, 14431, 34736, 11873, 30228,
				16870, 31724, 14731, 25659, 1236, 804, 8114, 11386, 3303, 15329, 20873, 20680, 7008, 27372, 30972, 9092,
				41788, 2602, 17868, 37865, 23409, 45486, 13754, 35399, 22474, 32512, 8965, 18531, 47119, 19051, 1460,
				23816, 32446, 1867, 49828, 39370, 15219, 15232, 3274, 36659, 43281, 35814, 19287, 11823, 31767, 19287,
				36010, 4481, 12560, 8092, 12123, 37206, 359, 21014, 8668, 33106, 48746, 9710, 48812, 3348, 12840, 11009,
				14692, 9861, 43134, 14684, 35003, 42350, 15874, 16384, 47065, 48633, 37490, 18785, 33871, 40370, 27774,
				15312, 47179, 37092, 9788, 24814, 38441, 43575, 44359, 47189, 38338, 49842, 8248, 43347, 11503, 25322,
				25160, 32972, 10191, 43260, 7554, 37283, 34649, 8383, 35519, 12621, 43484, 10883, 31741, 15152, 30755,
				4322, 21216, 3898, 32540, 8196, 29230, 9420, 33094, 35080, 26029, 25691, 7307, 2029, 10782, 12794,
				40087, 37012, 16270, 17530, 40917, 24954, 18277, 2791, 2395, 31534, 29192, 42047, 5290, 49682, 28306,
				8695, 28519, 13904, 40655, 1194, 71, 17599, 49042, 1477, 15551, 9945, 47021, 13398, 44130, 30932, 37568,
				17467, 42223, 10458, 32892, 48636, 12554, 18102, 24416, 25536, 40660, 1086, 24615, 4733, 35628, 48301,
				28426, 19373, 66, 19605, 7805, 12845, 31035, 8115, 23533, 42572, 14581, 43101, 40414, 10762, 40007, 543,
				42071, 25232, 24669, 37869, 2980, 10397, 41607, 35417, 10075, 41414, 16635, 31459, 39634, 47310, 25802,
				8911, 6486, 23595, 49072, 29302, 40096, 16095, 18404, 39668, 12166, 11001, 29415, 42331, 29178, 12746,
				25872, 41931, 4600, 12603, 46045, 28155, 12187, 28725, 3369, 4915, 3194, 43350, 10107, 9355, 28380,
				12436, 39557, 25617, 34545, 6508, 20993, 28598, 43403, 49609, 37919, 25185, 18619, 45068, 12423, 27546,
				2862, 2149, 49584, 21413, 16456, 24746, 32525, 19247, 5672, 21296, 37114, 9279, 3465, 5485, 3772, 11969,
				32195, 22170, 27734, 48229, 2697, 29138, 7947, 47968, 31896, 16659, 13269, 24714, 10979, 28166, 14621,
				48406, 24019, 25426, 49710, 45866, 6449, 45819, 30806, 40168, 26255, 21424, 42866, 47207, 49145, 41768,
				44583, 15040, 3588, 5071, 17401, 48381, 3757, 37524, 13969, 28369, 14068, 35907, 40899, 47897, 12815,
				2415, 4310, 20168, 42054, 49502, 4427, 40802, 202, 34764, 43713, 1694, 49304, 44355, 9517, 29506, 10322,
				3236, 41895, 3064, 42778, 15696, 14664, 12915, 35868, 2031, 29649, 15965, 27816, 14990, 42474, 9522,
				24028, 3744, 34363, 36010, 23303, 28526, 2293, 23492, 48934, 545, 14455, 31422, 37440, 26376, 14122,
				45269, 30834, 18397, 11100, 24173, 42649, 19122, 7024, 443, 38191, 34354, 35629, 26248, 36530, 25783,
				38963, 37153, 38419, 41136, 7292, 8562, 47210, 10699, 18233, 41663, 23614, 2961, 18573, 12707, 25188,
				41681, 41253, 4881, 30137, 3158, 10084, 44767, 3314, 10195, 9185, 29715, 11286, 9791, 11273, 37178,
				9188, 20584, 37712, 15462, 39882, 8156, 23740, 16546, 7258, 3179, 11521, 7844, 3554, 40588, 49831,
				45789, 15639, 3077, 19663, 9245, 35834, 388, 45058, 43428, 11419, 30009, 2078, 28260, 837, 8054, 11782,
				5227, 2595, 2952, 22023, 31332, 39777, 29489, 17729, 48775, 31601, 36402, 6647, 33327, 44788, 36830,
				40160, 16269, 14631, 20367, 36160, 27130, 31436, 1485, 19453, 37837, 46863, 31553, 28730, 13241, 47446,
				43684, 25774, 9687, 11635, 11481, 4341, 20819, 14281, 32713, 45482, 267, 6437, 22475, 48508, 1926,
				33767, 20756, 40953, 43738, 16376, 8505, 13181, 40395, 34433, 22826, 13779, 47878, 21930, 10485, 49777,
				27164, 28939, 45538, 11093, 25769, 23693, 24479, 19940, 17360, 12779, 23195, 7627, 23262, 40197, 43263,
				45693, 10842, 48176, 37787, 9671, 18051, 11457, 34616, 34469, 17170, 37154, 16001, 14662, 41448, 30495,
				13506, 42857, 44203, 16423, 44533, 17773, 42867, 43813, 32234, 20626, 11260, 24166, 20318, 257, 42929,
				816, 34776, 39244, 24985, 49506, 26793, 18576, 45861, 23248, 9517, 8441, 44654, 37434, 7678, 5516,
				37645, 37693, 40713, 5805, 49998, 6805, 11815, 14658, 23651, 3596, 14439, 24204, 26969, 27239, 35884,
				16590, 28687, 25589, 42859, 895, 47612, 34923, 43828, 46206, 22647, 49369, 49679, 30101, 46383, 37594,
				25327, 4713, 23426, 38077, 41551, 6973, 22932, 29292, 18546, 7600, 27660, 18936, 44361, 31537, 28365,
				30108, 9431, 12415, 24547, 39099, 48945, 12410, 26191, 9212, 33941, 20921, 2054, 11070, 34444, 6976,
				5054, 41564, 40772, 45918, 13707, 946, 40987, 31789, 20532, 30848, 27613, 11323, 39326, 21665, 47566,
				15948, 2091, 19280, 5564, 1621, 2261, 339, 44104, 48751, 29292, 14440, 40852, 20866, 20621, 39652,
				21118, 6299, 8577, 18892, 17394, 41667, 36545, 5079, 40188, 26323, 20780, 30808, 42209, 21097, 11481,
				37156, 20396, 2722, 18467, 27715, 1137, 35404, 36326, 39230, 13882, 9050, 43483, 6321, 47576, 35115,
				38109, 29710, 49858, 17280, 21917, 6510, 6831, 23365, 27532, 47763, 41838, 29093, 28389, 25260, 2411,
				40502, 35448, 22259, 498, 7521, 12421, 25434, 15443, 46184, 19213, 31340, 28444, 44670, 23554, 25897,
				28901, 29859, 28586, 5588, 38632, 19448, 31537, 19135, 31819, 4344, 10167, 44136, 6122, 6700, 44536,
				42850, 47556, 34760, 26081, 49954, 11664, 24369, 11971, 4492, 28046, 34225, 1146, 14898, 28504, 37203,
				11937, 34101, 6006, 30020, 3251, 14105, 24118, 21529, 7289, 9323, 15256, 41467, 642, 31736, 10846,
				32245, 18511, 13290, 37334, 17148, 40008, 36966, 17021, 29720, 3052, 19684, 21466, 4879, 31568, 29167,
				31727, 3179, 23904, 30484, 31990, 23686, 1197, 22544, 12865, 45254, 9992, 4732, 5046, 20466, 26679,
				26937, 20593, 17324, 44895, 44451, 33832, 43708, 17714, 8089, 25332, 14764, 48375, 5460, 31050, 9044,
				11740, 36753, 33778, 35472, 23146, 15641, 18545, 6027, 49492, 49780, 10624, 28896, 24089, 49750, 28972,
				14146, 25966, 3090, 18980, 17011, 175, 21843, 42982, 12066, 49228, 18614, 39835, 24895, 18991, 13316,
				19569, 45919, 49721, 23401, 45421, 32194, 18614, 43702, 16852, 47880, 29086, 42730, 14139, 13894, 13431,
				19627, 25086, 2438, 229, 36528, 41962, 7320, 24549, 25401, 22664, 14740, 43973, 4368, 48242, 2260,
				15025, 41493, 34432, 41963, 36391, 47643, 24492, 27079, 45934, 20931, 21696, 35742, 19467, 3810, 49684,
				18191, 16817, 29746, 42951, 24647, 39013, 37022, 25530, 2285, 36584, 40047, 44205, 18197, 2522, 34553,
				44792, 15442, 16720, 3875, 47795, 24925, 44577, 14219, 22221, 29749, 18246, 49301, 24987, 19544, 6302,
				35687, 34100, 44720, 49658, 49757, 12341, 10767, 33971, 29072, 17080, 1067, 49581, 27895, 36650, 2093,
				21961, 10674, 20899, 3462, 12324, 27319, 31063, 15024, 31290, 36715, 43166, 42762, 5388, 22900, 46777,
				28324, 11095, 46933, 38569, 35528, 44198, 22933, 7099, 21641, 4518, 13886, 3311, 7943, 8734, 7738,
				13394, 36483, 21534, 40689, 9206, 30570, 24777, 20378, 723, 29901, 9588, 24406, 31225, 35850, 30682,
				41083, 31333, 43920, 48633, 29064, 26422, 47113, 5295, 2503, 36604, 35980, 23217, 42467, 8549, 21427,
				31886, 27053, 187, 22897, 8040, 3981, 22987, 16370, 13410, 44719, 3349, 48465, 42071, 25048, 19121,
				48229, 34524, 48362, 26481, 42711, 44792, 2773, 8873, 3056, 13795, 46912, 14784, 38885, 25324, 48623,
				40572, 21062, 22735, 29461, 39590, 24072, 2461, 2673, 8038, 5474, 48807, 38864, 4486, 9907, 3561, 1738,
				6455, 675, 26757, 20784, 38442, 43765, 15963, 35961, 34429, 15381, 12953, 30352, 29605, 40656, 28775,
				26166, 868, 3580, 19680, 13409, 18939, 45215, 16049, 17879, 20892, 16640, 38322, 36880, 43451, 49725,
				46335, 22778, 4783, 17219, 35276, 13147, 27149, 10430, 38097, 28187, 9570, 37008, 14588, 25534, 707,
				21249, 24839, 4456, 45095, 28529, 42469, 37989, 7771, 33556, 32566, 15501, 31450, 4290, 49429, 11404,
				20355, 37131, 43567, 46125, 17240, 37343, 20517, 22574, 47030, 44799, 14851, 36504, 39196, 25185, 7355,
				18539, 14921, 45626, 16825, 26306, 35753, 37184, 30538, 18202, 36392, 12585, 13513, 48199, 11567, 35347,
				12750, 15455, 20272, 41027, 4873, 4267, 49049, 17179, 15120, 13766, 38077, 23940, 12957, 9875, 42566,
				10039, 25598, 29921, 4139, 34481, 38778, 10103, 13821, 12794, 31115, 30085, 9327, 22339, 3587, 2617,
				44000, 13602, 33182, 46569, 9820, 13664, 43056, 38825, 49772, 8619, 39772, 30025, 2931, 38289, 20662,
				29883, 15117, 13079, 5755, 25486, 17924, 5919, 1527, 23291, 34042, 46121, 10572, 21465, 20190, 31063,
				30789, 16981, 6907, 30219, 19535, 23602, 34644, 14182, 27257, 6089, 47171, 49460, 19060, 14849, 49451,
				48188, 26861, 49905, 18351, 7187, 14149, 37126, 13527, 18120, 28093, 22998, 583, 211, 42068, 31261,
				20913, 7989, 24426, 46645, 15476, 36228, 47063, 4875, 6335, 7149, 2214, 27016, 20175, 3369, 37246,
				40513, 3408, 23216, 11996, 21879, 29240, 21336, 553, 42185, 29912, 2377, 45877, 34168, 33224, 42709,
				42186, 41952, 49576, 3607, 26440, 7107, 27663, 42777, 44974, 33708, 6471, 43389, 22864, 25116, 28181,
				6671, 9484, 19676, 25106, 14678, 24837, 29607, 40420, 42113, 43947, 47734, 38540, 42870, 24926, 48323,
				35810, 31161, 27091, 10857, 8069, 41245, 48648, 44572, 3427, 14341, 7991, 4029, 31322, 24070, 11024,
				48088, 14876, 38540, 43001, 42527, 31846, 38855, 45418, 3688, 49688, 27282, 30664, 24368, 37983, 47273,
				37215, 18218, 46554, 11405, 13774, 39913, 32627, 14585, 30391, 22498, 13826, 8169, 11714, 48791, 11486,
				3514, 6208, 47045, 28614, 33768, 6959, 43462, 12431, 40252, 39123, 26486, 14521, 26556, 5119, 28567,
				24393, 28780, 29300, 44672, 35882, 27545, 39697, 6833, 45557, 28944, 734, 46653, 35612, 43027, 28399,
				2406, 3886, 26378, 44456, 3694, 42556, 29654, 27721, 22300, 3785, 38700, 40947, 29173, 32735, 17235,
				45009, 28114, 43030, 47795, 31923, 45687, 11049, 37471, 38362, 6000, 8337, 21013, 44317, 5292, 26053,
				15703, 3213, 16314, 22328, 40444, 19742, 43288, 13916, 24294, 28935, 47711, 44367, 12435, 33083, 13654,
				8085, 7255, 17861, 27680, 41070, 27509, 41386, 43961, 19935, 16262, 8256, 18341, 17541, 15463, 988,
				7698, 44823, 3000, 43751, 21921, 34099, 8846, 6272, 40710, 43719, 47271, 29858, 39026, 21117, 38034,
				16927, 4130, 39063, 14790, 19466, 43165, 26797, 19747, 10883, 12277, 42749, 19072, 16378, 11296, 9343,
				14705, 30705, 43816, 31296, 24267, 43407, 661, 37782, 22308, 25865, 3113, 24233, 48793, 15729, 20573,
				31202, 1548, 32481, 23715, 34038, 4999, 4229, 49358, 9356, 3507, 28847, 5937, 24375, 45667, 17241,
				15821, 10232, 16643, 33831, 47948, 42288, 23807, 26079, 32131, 42875, 11773, 32660, 21708, 35220, 47645,
				27204, 13020, 18165, 38660, 26234, 28905, 36671, 49951, 5721, 420, 14030, 23611, 39906, 5494, 2157,
				11993, 39526, 32013, 39573, 32407, 25511, 42184, 15040, 27771, 32429, 23707, 48623, 28938, 15605, 1450,
				33885, 49466, 11500, 42325, 11278, 30508, 12224, 37476, 14978, 8138, 3090, 26424, 42015, 33890, 2636,
				46068, 13925, 20992, 8673, 38215, 46240, 13076, 44298, 48193, 9259, 37200, 25553, 4903, 49354, 9697,
				28945, 44678, 17034, 47479, 31738, 24472, 35446, 46360, 36539, 16289, 46959, 2623, 11858, 23089, 17237,
				36070, 8285, 33456, 48637, 21073, 4582, 34170, 32478, 9503, 15987, 15390, 14110, 48288, 23138, 15055,
				39312, 40735, 45511, 21612, 8185, 46378, 21223, 47344, 39425, 8718, 34080, 17732, 9372, 28734, 22875,
				17735, 26264, 2862, 30124, 48649, 33371, 17178, 28493, 40782, 21047, 2299, 43861, 49728, 41885, 23664,
				19699, 14840, 48264, 3176, 48868, 42114, 3119, 33835, 43835, 12859, 42368, 17341, 13643, 6810, 23676,
				31924, 37879, 6289, 36708, 1075, 13269, 12470, 22959, 26606, 8155, 13926, 15526, 40031, 11958, 6268,
				30153, 16308, 15242, 38678, 201, 22759, 1903, 24542, 2674, 11317, 5589, 30940, 12479, 35198, 19138,
				2363, 16521, 43315, 30510, 1376, 39044, 14961, 10999, 33588, 9129, 27119, 22575, 37543, 12205, 41121,
				31911, 29422, 21694, 40598, 5513, 49858, 7072, 39228, 37751, 40214, 25127, 3405, 22925, 6155, 14165,
				29568, 46931, 27533, 28336, 43222, 12415, 44857, 3945, 38222, 25902, 9460, 15150, 23374, 42853, 3731,
				48531, 23876, 21595, 20078, 13973, 2136, 22100, 28725, 12555, 19561, 480, 31694, 3548, 28057, 3637,
				24244, 36854, 18545, 27666, 18532, 28418, 34533, 44877, 18078, 2967, 25531, 41002, 13807, 41110, 2401,
				47865, 13588, 6959, 6494, 47703, 2380, 20591, 49058, 14315, 20364, 47787, 26716, 36961, 31073, 4016,
				43793, 22270, 42905, 7493, 4591, 40291, 38547, 451, 45322, 24116, 36566, 23044, 44631, 49753, 2548,
				8226, 28289, 11648, 47871, 7341, 17927, 46086, 26938, 10041, 54, 12906, 36878, 27475, 27934, 20046,
				49697, 21517, 28580, 10261, 35446, 45353, 17168, 45881, 40723, 8153, 9339, 3115, 2932, 29244, 4191,
				45582, 33893, 36724, 17147, 18973, 40658, 45426, 36529, 11735, 31282, 15850, 11162, 41, 46084, 20185,
				35330, 16848, 7285, 3951, 37346, 47828, 11835, 34608, 1386, 23364, 42981, 35262, 4120, 39332, 40951,
				38419, 38827, 40667, 429, 23434, 34130, 9672, 33523, 1781, 33815, 10331, 27959, 24927, 30616, 612,
				26922, 33105, 5241, 5965, 736, 12098, 21445, 33742, 25217, 19251, 10761, 46632, 16203, 87, 29626, 901,
				41512, 12612, 14843, 32978, 44699, 9987, 38891, 2509, 5507, 39313, 18755, 13693, 4171, 19998, 6537,
				20833, 32003, 4117, 2198, 39796, 949, 36532, 28412, 679, 11586, 42042, 10108, 35591, 35867, 8020, 18665,
				24817, 9410, 11025, 20010, 47684, 26209, 10341, 8635, 18698, 21123, 34552, 44744, 25741, 49169, 40585,
				40890, 31726, 17988, 34567, 18609, 42232, 30427, 49189, 20229, 1354, 261, 23140, 17820, 10341, 26201,
				26675, 26716, 31141, 31777, 33700, 3292, 35141, 16168, 15729, 28700, 15517, 3922, 7995, 30646, 38373,
				27365, 28423, 36140, 42452, 43042, 23491, 17564, 43837, 3597, 23140, 35190, 28036, 21845, 24864, 42057,
				26019, 824, 37704, 32522, 3170, 9083, 42110, 38228, 22363, 20473, 1879, 46463, 25602, 5131, 27117,
				42812, 34226, 25214, 43645, 48889, 4518, 47811, 12657, 21881, 4937, 5340, 3209, 36153, 34208, 47001,
				3007, 48994, 19283, 21081, 4240, 44746, 47026, 17390, 5172, 7882, 41964, 619, 12225, 17442, 35945,
				39804, 2689, 34157, 34304, 3885, 36861, 21826, 10749, 36982, 13388, 1501, 16475, 39006, 26708, 27222,
				47113, 26587, 27308, 13689, 40060, 10866, 32525, 11694, 5721, 12869, 36909, 14750, 32977, 1173, 42940,
				36619, 13810, 14925, 28900, 43638, 38314, 33755, 10280, 31223, 15240, 36731, 32782, 30067, 5288, 48773,
				11454, 23572, 21985, 30258, 12322, 4789, 37962, 30460, 6755, 2688, 44086, 38934, 2984, 37507, 24085,
				7626, 19380, 8742, 21695, 24406, 16150, 10870, 7321, 5921, 22520, 12993, 5566, 44109, 10084, 23960,
				11045, 42662, 7571, 15785, 46864, 30795, 49474, 29814, 10750, 31326, 41614, 7194, 4567, 30849, 6912,
				34332, 43263, 23067, 44162, 27254, 27159, 21380, 22911, 2261, 23700, 33292, 21737, 29286, 2268, 10279,
				10674, 8779, 6906, 10743, 19817, 41136, 44825, 22966, 15402, 43534, 41499, 15220, 39446, 22623, 1918,
				38232, 21680, 49355, 37966, 10001, 49312, 4726, 5463, 24121, 37264, 42027, 34756, 22877, 31051, 30581,
				23010, 41908, 5820, 29892, 40976, 49049, 27463, 3988, 25140, 13036, 48994, 36636, 19277, 2484, 21409,
				14560, 43151, 25879, 47863, 1147, 25817, 32261, 28604, 19617, 29059, 13941, 41192, 25151, 37385, 17594,
				5830, 9685, 405, 15902, 31965, 20511, 20736, 5446, 20054, 43513, 9471, 11306, 125, 33602, 13305, 33232,
				48144, 33513, 3931, 17472, 30874, 6236, 17143, 21773, 19567, 18264, 23777, 41844, 14915, 43384, 35715,
				12628, 40410, 29929, 4298, 35790, 38007, 49168, 45460, 43610, 17564, 24756, 9192, 36087, 9347, 6194,
				22060, 42259, 7876, 19505, 9484, 3448, 9874, 42508, 36907, 996, 46785, 42379, 26682, 46907, 45214,
				10336, 15377, 6082, 13093, 17468, 29904, 8599, 31026, 11648, 27806, 24427, 19563, 1517, 24779, 5525,
				17902, 9047, 37586, 31560, 464, 19776, 43598, 11732, 24059, 10578, 4835, 17517, 412, 8393, 22323, 43709,
				23618, 33569, 35480, 42996, 43626, 10094, 7284, 49714, 13284, 29380, 18144, 43312, 41150, 13533, 49259,
				13723, 29438, 13176, 33795, 4870, 5972, 26639, 26627, 28286, 40100, 36435, 43729, 30080, 11384, 32552,
				37468, 47132, 17025, 7063, 13222, 19821, 6341, 41188, 24480, 20376, 22760, 5972, 260, 14003, 20888,
				6308, 40223, 13889, 29520, 44651, 26197, 25132, 34828, 13079, 16295, 28595, 27957, 8421, 23112, 18111,
				41085, 23608, 8114, 2979, 45111, 47003, 42074, 24942, 46258, 24529, 32196, 37519, 12063, 20942, 5361,
				39601, 29748, 16106, 20106, 47825, 34820, 27307, 36794, 37937, 45063, 46368, 40834, 37943, 35125, 26113,
				26130, 8570, 14225, 12636, 1045, 49222, 10457, 22693, 8726, 19509, 21054, 5342, 43449, 1622, 3256, 4047,
				45954, 17022, 33275, 12555, 12303, 35569, 15377, 21910, 33777, 49942, 37841, 24592, 14266, 5350, 18944,
				7997, 14204, 7122, 17112, 47235, 24565, 36988, 35405, 35520, 8367, 17519, 5887, 12897, 43280, 49713,
				45420, 20783, 49935, 1086, 22980, 26644, 5669, 13914, 43816, 38043, 2582, 1227, 29345, 20022, 36594,
				15572, 32924, 49715, 1178, 25422, 29852, 11457, 28852, 47643, 35326, 2212, 608, 8565, 19933, 31286,
				40391, 31736, 41351, 42299, 42285, 36017, 46475, 2300, 48988, 29579, 16147, 12846, 4725, 876, 28180,
				9411, 278, 3725, 35102, 17724, 21133, 4409, 14487, 198, 35580, 8825, 6295, 22905, 41718, 13106, 18200,
				31542, 11415, 48834, 43445, 30331, 40881, 9409, 34997, 20766, 10604, 25847, 38709, 13655, 19571, 39100,
				44276, 43285, 16668, 29979, 28734, 8960, 12068, 11472, 10251, 32657, 26643, 48906, 21270, 11014, 40465,
				9179, 17347, 35422, 42526, 47238, 43244, 42407, 1504, 26454, 35058, 17855, 42827, 11267, 35622, 23134,
				47941, 49053, 7108, 35049, 16419, 2944, 11483, 41484, 45365, 27792, 1573, 4261, 42288, 1310, 37766,
				35487, 531, 30288, 35322, 28234, 23945, 39534, 9528, 11607, 3614, 636, 24156, 47515, 38470, 42519,
				46315, 5426, 3585, 8039, 9540, 10167, 1430, 16751, 14373, 37457, 48592, 37092, 12547, 44348, 4629,
				22570, 26627, 22588, 48183, 32345, 25196, 33291, 12535, 17614, 47155, 36154, 12476, 47438, 27001, 15636,
				24949, 14327, 6567, 21155, 11018, 26469, 44393, 15665, 20793, 35576, 24332, 2090, 13586, 10644, 21050,
				19866, 40617, 29885, 6530, 928, 12257, 49545, 46801, 35782, 24089, 13310, 10377, 18223, 10555, 7277,
				12502, 24696, 36692, 28290, 20252, 13531, 4299, 18538, 32766, 32909, 30330, 14886, 40549, 47444, 3257,
				17011, 21306, 25685, 37688, 48172, 10154, 42754, 22141, 21577, 29580, 11031, 34202, 6472, 29832, 8257,
				10103, 16, 25094, 11096, 8633, 7166, 36433, 41776, 13555, 41459, 7196, 3635, 37787, 49785, 32154, 14646,
				35451, 26072, 47020, 22835, 19226, 5947, 14680, 24133, 48842, 1589, 6233, 17267, 18284, 18958, 36129,
				20315, 11950, 28277, 45091, 32073, 21119, 24663, 18423, 35924, 26396, 13678, 27379, 22976, 4638, 45882,
				34972, 29237, 19944, 20145, 25983, 23020, 46345, 43425, 1891, 18687, 8502, 7391, 49016, 21153, 15505,
				44020, 15964, 33803, 38788, 45050, 22518, 9204, 39364, 3010, 22904, 10971, 38207, 16468, 34723, 42062,
				26204, 46698, 3869, 47504, 40669, 14834, 19673, 22097, 22523, 33686, 48863, 39484, 48512, 2814, 155,
				27039, 18566, 463, 6505, 8993, 38332, 18499, 7164, 2756, 17919, 3412, 39825, 31275, 32723, 3409, 13546,
				12612, 48374, 3110, 22861, 18396, 24435, 33663, 14837, 21008, 21155, 32257, 2245, 38767, 41274, 8747,
				8420, 37271, 12392, 42913, 15390, 46785, 3565, 5874, 2276, 3332, 12532, 49443, 23512, 27053, 47286,
				10329, 12727, 13655, 24470, 43203, 15917, 15029, 1671, 27606, 20944, 35958, 42502, 25300, 8499, 22401,
				43376, 42679, 8736, 6196, 29657, 49476, 18831, 47921, 26336, 26328, 39070, 6570, 13579, 46442, 41704,
				20959, 47074, 38641, 23008, 45082, 25774, 25553, 30529, 19990, 4582, 31540, 3700, 31866, 47285, 7507,
				21377, 11945, 11349, 20853, 26867, 9617, 37534, 11287, 45328, 11978, 47555, 39894, 23725, 26463, 5747,
				40365, 14159, 39554, 47578, 39554, 48578, 48003, 40609, 10201, 48707, 48735, 31943, 24535, 17808, 47018,
				11467, 20001, 31724, 2286, 25190, 8742, 40463, 30071, 20039, 22449, 39995, 37362, 7957, 22552, 27998,
				15844, 7146, 356, 30277, 7878, 21301, 40051, 32513, 39492, 13808, 6637, 32965, 1507, 49241, 34964,
				19494, 27129, 13492, 20612, 27851, 41439, 38949, 12738, 10937, 48496, 11410, 3186, 32353, 28427, 7539,
				11328, 718, 43030, 38841, 2627, 5432, 29912, 37289, 28194, 22802, 12441, 34583, 3604, 23382, 31163,
				49570, 6059, 24006, 11888, 25075, 15855, 46211, 5264, 34160, 16906, 36319, 38720, 2091, 36896, 26874,
				9529, 33541, 17480, 28538, 14421, 21473, 28289, 14303, 36611, 6685, 14152, 23628, 35737, 32644, 35853,
				10521, 49731, 20514, 25022, 7318, 15226, 48765, 26224, 28079, 30368, 25897, 40478, 18801, 45642, 8205,
				13854, 21315, 1589, 35530, 4720, 41402, 5186, 20855, 27741, 3602, 31766, 40051, 46173, 34207, 7620,
				1014, 42362, 30282, 44057, 15926, 30764, 43994, 40719, 19000, 24835, 23013, 16995, 35732, 13617, 46357,
				45487, 45110, 35007, 4043, 45869, 34827, 42326, 8108, 43474, 6767, 36620, 35161, 7989, 3013, 5295,
				11544, 48406, 19021, 26683, 4066, 5500, 7511, 12594, 39463, 9556, 29653, 547, 12148, 12856, 14126,
				14031, 10687, 47870, 191, 23789, 32980, 49698, 42097, 1567, 15279, 2954, 40839, 9248, 10890, 7476,
				15574, 26845, 9479, 13636, 42505, 22690, 3383, 4611, 44399, 24534, 18676, 19990, 3177, 14108, 30891,
				1860, 5346, 34084, 3014, 5757, 32662, 14040, 7519, 41210, 7463, 1206, 2085, 41939, 26664, 29072, 7506,
				2972, 1067, 35873, 59, 39110, 16821, 6629, 44261, 16483, 20002, 10608, 49615, 24373, 3542, 6558, 35209,
				22324, 22033, 9938, 33292, 36270, 27026, 5998, 35710, 18291, 35188, 39938, 5754, 28690, 6442, 7704,
				3453, 45423, 3266, 4705, 41952, 2517, 9279, 13127, 27232, 44560, 19948, 41100, 34841, 36622, 48903,
				14342, 18614, 42274, 5260, 34442, 4654, 40510, 17406, 33588, 20147, 29523, 32418, 40232, 17820, 28177,
				27718, 16228, 1946, 24015, 7014, 48827, 11161, 44510, 43855, 40478, 46480, 9954, 32904, 45473, 9905,
				29727, 10892, 40828, 469, 39676, 822, 27187, 24784, 21427, 33696, 31149, 39541, 37885, 18612, 1090,
				47640, 848, 117, 5543, 47819, 8673, 45898, 16173, 45844, 31870, 13066, 6879, 5506, 17960, 6591, 12561,
				48639, 8461, 19758, 8896, 22095, 9503, 35182, 8368, 48639, 6901, 38409, 46755, 25980, 31311, 14741,
				3420, 29824, 14345, 36020, 36076, 45269, 33103, 31107, 37756, 14284, 47589, 19675, 13654, 24100, 18969,
				47460, 1847, 41598, 40590, 31636, 34660, 48714, 11255, 41265, 25752, 37320, 44449, 43730, 18387, 45473,
				9312, 44428, 17792, 28973, 24600, 11174, 38693, 40863, 1913, 29287, 19500, 28035, 26653, 37260, 27402,
				28191, 25496, 11311, 48238, 35163, 40081, 24779, 12590, 12533, 4896, 42126, 30492, 43905, 44500, 34307,
				37517, 21182, 15347, 48020, 46641, 25435, 49627, 4993, 18636, 6780, 8114, 25461, 1447, 13743, 40144,
				26599, 36445, 29721, 25774, 16476, 5247, 15599, 25890, 6450, 33477, 18722, 29487, 43240, 18894, 16616,
				28632, 34797, 30301, 15659, 22771, 21190, 15306, 22738, 43418, 1337, 16491, 41591, 33101, 7829, 49438,
				31590, 49819, 43887, 21048, 19703, 3557, 2525, 17470, 35489, 25709, 26597, 11729, 37589, 5259, 21925,
				17321, 118, 20840, 19532, 49321, 14906 };
		System.out.println(solve(nums));
	}

	private static int solve(int[] nums) {

		TreeMap<Integer, Integer> map = new TreeMap<>();

		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		NavigableMap<Integer, Integer> reverseMap = map.descendingMap();

		for (Entry<Integer, Integer> eachEntry : reverseMap.entrySet()) {
			if (null == map.lowerKey(eachEntry.getKey())) {
				break;
			}
			count += eachEntry.getValue();

			int nextLargest = map.lowerKey(eachEntry.getKey());
			map.put(nextLargest, map.get(nextLargest) + eachEntry.getValue());
		}

		return count;
	}

}