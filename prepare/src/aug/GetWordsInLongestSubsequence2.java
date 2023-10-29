package aug;

import java.util.ArrayList;
import java.util.List;

public class GetWordsInLongestSubsequence2 {

	public static void main(String[] args) {
		int n = 1000;
		String[] words = { "akvybqpnzv", "bkvybqpnzv", "ckvybqpnzv", "dkvybqpnzv", "ekvybqpnzv", "fkvybqpnzv",
				"gkvybqpnzv", "hkvybqpnzv", "ikvybqpnzv", "jkvybqpnzv", "kkvybqpnzv", "lkvybqpnzv", "mkvybqpnzv",
				"nkvybqpnzv", "okvybqpnzv", "pkvybqpnzv", "qkvybqpnzv", "rkvybqpnzv", "skvybqpnzv", "tkvybqpnzv",
				"ukvybqpnzv", "vkvybqpnzv", "wkvybqpnzv", "xkvybqpnzv", "ykvybqpnzv", "zkvybqpnzv", "zavybqpnzv",
				"aavybqpnzv", "bavybqpnzv", "cavybqpnzv", "davybqpnzv", "eavybqpnzv", "favybqpnzv", "gavybqpnzv",
				"havybqpnzv", "iavybqpnzv", "javybqpnzv", "kavybqpnzv", "lavybqpnzv", "mavybqpnzv", "navybqpnzv",
				"oavybqpnzv", "pavybqpnzv", "qavybqpnzv", "ravybqpnzv", "savybqpnzv", "tavybqpnzv", "uavybqpnzv",
				"vavybqpnzv", "wavybqpnzv", "xavybqpnzv", "yavybqpnzv", "ybvybqpnzv", "abvybqpnzv", "bbvybqpnzv",
				"cbvybqpnzv", "dbvybqpnzv", "ebvybqpnzv", "fbvybqpnzv", "gbvybqpnzv", "hbvybqpnzv", "ibvybqpnzv",
				"jbvybqpnzv", "kbvybqpnzv", "lbvybqpnzv", "mbvybqpnzv", "nbvybqpnzv", "obvybqpnzv", "pbvybqpnzv",
				"qbvybqpnzv", "rbvybqpnzv", "sbvybqpnzv", "tbvybqpnzv", "ubvybqpnzv", "vbvybqpnzv", "wbvybqpnzv",
				"xbvybqpnzv", "zbvybqpnzv", "zcvybqpnzv", "acvybqpnzv", "bcvybqpnzv", "ccvybqpnzv", "dcvybqpnzv",
				"ecvybqpnzv", "fcvybqpnzv", "gcvybqpnzv", "hcvybqpnzv", "icvybqpnzv", "jcvybqpnzv", "kcvybqpnzv",
				"lcvybqpnzv", "mcvybqpnzv", "ncvybqpnzv", "ocvybqpnzv", "pcvybqpnzv", "qcvybqpnzv", "rcvybqpnzv",
				"scvybqpnzv", "tcvybqpnzv", "ucvybqpnzv", "vcvybqpnzv", "wcvybqpnzv", "xcvybqpnzv", "ycvybqpnzv",
				"ydvybqpnzv", "advybqpnzv", "bdvybqpnzv", "cdvybqpnzv", "ddvybqpnzv", "edvybqpnzv", "fdvybqpnzv",
				"gdvybqpnzv", "hdvybqpnzv", "idvybqpnzv", "jdvybqpnzv", "kdvybqpnzv", "ldvybqpnzv", "mdvybqpnzv",
				"ndvybqpnzv", "odvybqpnzv", "pdvybqpnzv", "qdvybqpnzv", "rdvybqpnzv", "sdvybqpnzv", "tdvybqpnzv",
				"udvybqpnzv", "vdvybqpnzv", "wdvybqpnzv", "xdvybqpnzv", "zdvybqpnzv", "zevybqpnzv", "aevybqpnzv",
				"bevybqpnzv", "cevybqpnzv", "devybqpnzv", "eevybqpnzv", "fevybqpnzv", "gevybqpnzv", "hevybqpnzv",
				"ievybqpnzv", "jevybqpnzv", "kevybqpnzv", "levybqpnzv", "mevybqpnzv", "nevybqpnzv", "oevybqpnzv",
				"pevybqpnzv", "qevybqpnzv", "revybqpnzv", "sevybqpnzv", "tevybqpnzv", "uevybqpnzv", "vevybqpnzv",
				"wevybqpnzv", "xevybqpnzv", "yevybqpnzv", "yfvybqpnzv", "afvybqpnzv", "bfvybqpnzv", "cfvybqpnzv",
				"dfvybqpnzv", "efvybqpnzv", "ffvybqpnzv", "gfvybqpnzv", "hfvybqpnzv", "ifvybqpnzv", "jfvybqpnzv",
				"kfvybqpnzv", "lfvybqpnzv", "mfvybqpnzv", "nfvybqpnzv", "ofvybqpnzv", "pfvybqpnzv", "qfvybqpnzv",
				"rfvybqpnzv", "sfvybqpnzv", "tfvybqpnzv", "ufvybqpnzv", "vfvybqpnzv", "wfvybqpnzv", "xfvybqpnzv",
				"zfvybqpnzv", "zgvybqpnzv", "agvybqpnzv", "bgvybqpnzv", "cgvybqpnzv", "dgvybqpnzv", "egvybqpnzv",
				"fgvybqpnzv", "ggvybqpnzv", "hgvybqpnzv", "igvybqpnzv", "jgvybqpnzv", "kgvybqpnzv", "lgvybqpnzv",
				"mgvybqpnzv", "ngvybqpnzv", "ogvybqpnzv", "pgvybqpnzv", "qgvybqpnzv", "rgvybqpnzv", "sgvybqpnzv",
				"tgvybqpnzv", "ugvybqpnzv", "vgvybqpnzv", "wgvybqpnzv", "xgvybqpnzv", "ygvybqpnzv", "yhvybqpnzv",
				"ahvybqpnzv", "bhvybqpnzv", "chvybqpnzv", "dhvybqpnzv", "ehvybqpnzv", "fhvybqpnzv", "ghvybqpnzv",
				"hhvybqpnzv", "ihvybqpnzv", "jhvybqpnzv", "khvybqpnzv", "lhvybqpnzv", "mhvybqpnzv", "nhvybqpnzv",
				"ohvybqpnzv", "phvybqpnzv", "qhvybqpnzv", "rhvybqpnzv", "shvybqpnzv", "thvybqpnzv", "uhvybqpnzv",
				"vhvybqpnzv", "whvybqpnzv", "xhvybqpnzv", "zhvybqpnzv", "zivybqpnzv", "aivybqpnzv", "bivybqpnzv",
				"civybqpnzv", "divybqpnzv", "eivybqpnzv", "fivybqpnzv", "givybqpnzv", "hivybqpnzv", "iivybqpnzv",
				"jivybqpnzv", "kivybqpnzv", "livybqpnzv", "mivybqpnzv", "nivybqpnzv", "oivybqpnzv", "pivybqpnzv",
				"qivybqpnzv", "rivybqpnzv", "sivybqpnzv", "tivybqpnzv", "uivybqpnzv", "vivybqpnzv", "wivybqpnzv",
				"xivybqpnzv", "yivybqpnzv", "yjvybqpnzv", "ajvybqpnzv", "bjvybqpnzv", "cjvybqpnzv", "djvybqpnzv",
				"ejvybqpnzv", "fjvybqpnzv", "gjvybqpnzv", "hjvybqpnzv", "ijvybqpnzv", "jjvybqpnzv", "kjvybqpnzv",
				"ljvybqpnzv", "mjvybqpnzv", "njvybqpnzv", "ojvybqpnzv", "pjvybqpnzv", "qjvybqpnzv", "rjvybqpnzv",
				"sjvybqpnzv", "tjvybqpnzv", "ujvybqpnzv", "vjvybqpnzv", "wjvybqpnzv", "xjvybqpnzv", "zjvybqpnzv",
				"zlvybqpnzv", "alvybqpnzv", "blvybqpnzv", "clvybqpnzv", "dlvybqpnzv", "elvybqpnzv", "flvybqpnzv",
				"glvybqpnzv", "hlvybqpnzv", "ilvybqpnzv", "jlvybqpnzv", "klvybqpnzv", "llvybqpnzv", "mlvybqpnzv",
				"nlvybqpnzv", "olvybqpnzv", "plvybqpnzv", "qlvybqpnzv", "rlvybqpnzv", "slvybqpnzv", "tlvybqpnzv",
				"ulvybqpnzv", "vlvybqpnzv", "wlvybqpnzv", "xlvybqpnzv", "ylvybqpnzv", "ymvybqpnzv", "amvybqpnzv",
				"bmvybqpnzv", "cmvybqpnzv", "dmvybqpnzv", "emvybqpnzv", "fmvybqpnzv", "gmvybqpnzv", "hmvybqpnzv",
				"imvybqpnzv", "jmvybqpnzv", "kmvybqpnzv", "lmvybqpnzv", "mmvybqpnzv", "nmvybqpnzv", "omvybqpnzv",
				"pmvybqpnzv", "qmvybqpnzv", "rmvybqpnzv", "smvybqpnzv", "tmvybqpnzv", "umvybqpnzv", "vmvybqpnzv",
				"wmvybqpnzv", "xmvybqpnzv", "zmvybqpnzv", "znvybqpnzv", "anvybqpnzv", "bnvybqpnzv", "cnvybqpnzv",
				"dnvybqpnzv", "envybqpnzv", "fnvybqpnzv", "gnvybqpnzv", "hnvybqpnzv", "invybqpnzv", "jnvybqpnzv",
				"knvybqpnzv", "lnvybqpnzv", "mnvybqpnzv", "nnvybqpnzv", "onvybqpnzv", "pnvybqpnzv", "qnvybqpnzv",
				"rnvybqpnzv", "snvybqpnzv", "tnvybqpnzv", "unvybqpnzv", "vnvybqpnzv", "wnvybqpnzv", "xnvybqpnzv",
				"ynvybqpnzv", "yovybqpnzv", "aovybqpnzv", "bovybqpnzv", "covybqpnzv", "dovybqpnzv", "eovybqpnzv",
				"fovybqpnzv", "govybqpnzv", "hovybqpnzv", "iovybqpnzv", "jovybqpnzv", "kovybqpnzv", "lovybqpnzv",
				"movybqpnzv", "novybqpnzv", "oovybqpnzv", "povybqpnzv", "qovybqpnzv", "rovybqpnzv", "sovybqpnzv",
				"tovybqpnzv", "uovybqpnzv", "vovybqpnzv", "wovybqpnzv", "xovybqpnzv", "zovybqpnzv", "zpvybqpnzv",
				"apvybqpnzv", "bpvybqpnzv", "cpvybqpnzv", "dpvybqpnzv", "epvybqpnzv", "fpvybqpnzv", "gpvybqpnzv",
				"hpvybqpnzv", "ipvybqpnzv", "jpvybqpnzv", "kpvybqpnzv", "lpvybqpnzv", "mpvybqpnzv", "npvybqpnzv",
				"opvybqpnzv", "ppvybqpnzv", "qpvybqpnzv", "rpvybqpnzv", "spvybqpnzv", "tpvybqpnzv", "upvybqpnzv",
				"vpvybqpnzv", "wpvybqpnzv", "xpvybqpnzv", "ypvybqpnzv", "yqvybqpnzv", "aqvybqpnzv", "bqvybqpnzv",
				"cqvybqpnzv", "dqvybqpnzv", "eqvybqpnzv", "fqvybqpnzv", "gqvybqpnzv", "hqvybqpnzv", "iqvybqpnzv",
				"jqvybqpnzv", "kqvybqpnzv", "lqvybqpnzv", "mqvybqpnzv", "nqvybqpnzv", "oqvybqpnzv", "pqvybqpnzv",
				"qqvybqpnzv", "rqvybqpnzv", "sqvybqpnzv", "tqvybqpnzv", "uqvybqpnzv", "vqvybqpnzv", "wqvybqpnzv",
				"xqvybqpnzv", "zqvybqpnzv", "zrvybqpnzv", "arvybqpnzv", "brvybqpnzv", "crvybqpnzv", "drvybqpnzv",
				"ervybqpnzv", "frvybqpnzv", "grvybqpnzv", "hrvybqpnzv", "irvybqpnzv", "jrvybqpnzv", "krvybqpnzv",
				"lrvybqpnzv", "mrvybqpnzv", "nrvybqpnzv", "orvybqpnzv", "prvybqpnzv", "qrvybqpnzv", "rrvybqpnzv",
				"srvybqpnzv", "trvybqpnzv", "urvybqpnzv", "vrvybqpnzv", "wrvybqpnzv", "xrvybqpnzv", "yrvybqpnzv",
				"ysvybqpnzv", "asvybqpnzv", "bsvybqpnzv", "csvybqpnzv", "dsvybqpnzv", "esvybqpnzv", "fsvybqpnzv",
				"gsvybqpnzv", "hsvybqpnzv", "isvybqpnzv", "jsvybqpnzv", "ksvybqpnzv", "lsvybqpnzv", "msvybqpnzv",
				"nsvybqpnzv", "osvybqpnzv", "psvybqpnzv", "qsvybqpnzv", "rsvybqpnzv", "ssvybqpnzv", "tsvybqpnzv",
				"usvybqpnzv", "vsvybqpnzv", "wsvybqpnzv", "xsvybqpnzv", "zsvybqpnzv", "ztvybqpnzv", "atvybqpnzv",
				"btvybqpnzv", "ctvybqpnzv", "dtvybqpnzv", "etvybqpnzv", "ftvybqpnzv", "gtvybqpnzv", "htvybqpnzv",
				"itvybqpnzv", "jtvybqpnzv", "ktvybqpnzv", "ltvybqpnzv", "mtvybqpnzv", "ntvybqpnzv", "otvybqpnzv",
				"ptvybqpnzv", "qtvybqpnzv", "rtvybqpnzv", "stvybqpnzv", "ttvybqpnzv", "utvybqpnzv", "vtvybqpnzv",
				"wtvybqpnzv", "xtvybqpnzv", "ytvybqpnzv", "yuvybqpnzv", "auvybqpnzv", "buvybqpnzv", "cuvybqpnzv",
				"duvybqpnzv", "euvybqpnzv", "fuvybqpnzv", "guvybqpnzv", "huvybqpnzv", "iuvybqpnzv", "juvybqpnzv",
				"kuvybqpnzv", "luvybqpnzv", "muvybqpnzv", "nuvybqpnzv", "ouvybqpnzv", "puvybqpnzv", "quvybqpnzv",
				"ruvybqpnzv", "suvybqpnzv", "tuvybqpnzv", "uuvybqpnzv", "vuvybqpnzv", "wuvybqpnzv", "xuvybqpnzv",
				"zuvybqpnzv", "zvvybqpnzv", "avvybqpnzv", "bvvybqpnzv", "cvvybqpnzv", "dvvybqpnzv", "evvybqpnzv",
				"fvvybqpnzv", "gvvybqpnzv", "hvvybqpnzv", "ivvybqpnzv", "jvvybqpnzv", "kvvybqpnzv", "lvvybqpnzv",
				"mvvybqpnzv", "nvvybqpnzv", "ovvybqpnzv", "pvvybqpnzv", "qvvybqpnzv", "rvvybqpnzv", "svvybqpnzv",
				"tvvybqpnzv", "uvvybqpnzv", "vvvybqpnzv", "wvvybqpnzv", "xvvybqpnzv", "yvvybqpnzv", "ywvybqpnzv",
				"awvybqpnzv", "bwvybqpnzv", "cwvybqpnzv", "dwvybqpnzv", "ewvybqpnzv", "fwvybqpnzv", "gwvybqpnzv",
				"hwvybqpnzv", "iwvybqpnzv", "jwvybqpnzv", "kwvybqpnzv", "lwvybqpnzv", "mwvybqpnzv", "nwvybqpnzv",
				"owvybqpnzv", "pwvybqpnzv", "qwvybqpnzv", "rwvybqpnzv", "swvybqpnzv", "twvybqpnzv", "uwvybqpnzv",
				"vwvybqpnzv", "wwvybqpnzv", "xwvybqpnzv", "zwvybqpnzv", "zxvybqpnzv", "axvybqpnzv", "bxvybqpnzv",
				"cxvybqpnzv", "dxvybqpnzv", "exvybqpnzv", "fxvybqpnzv", "gxvybqpnzv", "hxvybqpnzv", "ixvybqpnzv",
				"jxvybqpnzv", "kxvybqpnzv", "lxvybqpnzv", "mxvybqpnzv", "nxvybqpnzv", "oxvybqpnzv", "pxvybqpnzv",
				"qxvybqpnzv", "rxvybqpnzv", "sxvybqpnzv", "txvybqpnzv", "uxvybqpnzv", "vxvybqpnzv", "wxvybqpnzv",
				"xxvybqpnzv", "yxvybqpnzv", "yyvybqpnzv", "ayvybqpnzv", "byvybqpnzv", "cyvybqpnzv", "dyvybqpnzv",
				"eyvybqpnzv", "fyvybqpnzv", "gyvybqpnzv", "hyvybqpnzv", "iyvybqpnzv", "jyvybqpnzv", "kyvybqpnzv",
				"lyvybqpnzv", "myvybqpnzv", "nyvybqpnzv", "oyvybqpnzv", "pyvybqpnzv", "qyvybqpnzv", "ryvybqpnzv",
				"syvybqpnzv", "tyvybqpnzv", "uyvybqpnzv", "vyvybqpnzv", "wyvybqpnzv", "xyvybqpnzv", "zyvybqpnzv",
				"zzvybqpnzv", "azvybqpnzv", "bzvybqpnzv", "czvybqpnzv", "dzvybqpnzv", "ezvybqpnzv", "fzvybqpnzv",
				"gzvybqpnzv", "hzvybqpnzv", "izvybqpnzv", "jzvybqpnzv", "kzvybqpnzv", "lzvybqpnzv", "mzvybqpnzv",
				"nzvybqpnzv", "ozvybqpnzv", "pzvybqpnzv", "qzvybqpnzv", "rzvybqpnzv", "szvybqpnzv", "tzvybqpnzv",
				"uzvybqpnzv", "vzvybqpnzv", "wzvybqpnzv", "xzvybqpnzv", "yzvybqpnzv", "yzaybqpnzv", "azaybqpnzv",
				"bzaybqpnzv", "czaybqpnzv", "dzaybqpnzv", "ezaybqpnzv", "fzaybqpnzv", "gzaybqpnzv", "hzaybqpnzv",
				"izaybqpnzv", "jzaybqpnzv", "kzaybqpnzv", "lzaybqpnzv", "mzaybqpnzv", "nzaybqpnzv", "ozaybqpnzv",
				"pzaybqpnzv", "qzaybqpnzv", "rzaybqpnzv", "szaybqpnzv", "tzaybqpnzv", "uzaybqpnzv", "vzaybqpnzv",
				"wzaybqpnzv", "xzaybqpnzv", "zzaybqpnzv", "zaaybqpnzv", "aaaybqpnzv", "baaybqpnzv", "caaybqpnzv",
				"daaybqpnzv", "eaaybqpnzv", "faaybqpnzv", "gaaybqpnzv", "haaybqpnzv", "iaaybqpnzv", "jaaybqpnzv",
				"kaaybqpnzv", "laaybqpnzv", "maaybqpnzv", "naaybqpnzv", "oaaybqpnzv", "paaybqpnzv", "qaaybqpnzv",
				"raaybqpnzv", "saaybqpnzv", "taaybqpnzv", "uaaybqpnzv", "vaaybqpnzv", "waaybqpnzv", "xaaybqpnzv",
				"yaaybqpnzv", "ybaybqpnzv", "abaybqpnzv", "bbaybqpnzv", "cbaybqpnzv", "dbaybqpnzv", "ebaybqpnzv",
				"fbaybqpnzv", "gbaybqpnzv", "hbaybqpnzv", "ibaybqpnzv", "jbaybqpnzv", "kbaybqpnzv", "lbaybqpnzv",
				"mbaybqpnzv", "nbaybqpnzv", "obaybqpnzv", "pbaybqpnzv", "qbaybqpnzv", "rbaybqpnzv", "sbaybqpnzv",
				"tbaybqpnzv", "ubaybqpnzv", "vbaybqpnzv", "wbaybqpnzv", "xbaybqpnzv", "zbaybqpnzv", "zcaybqpnzv",
				"acaybqpnzv", "bcaybqpnzv", "ccaybqpnzv", "dcaybqpnzv", "ecaybqpnzv", "fcaybqpnzv", "gcaybqpnzv",
				"hcaybqpnzv", "icaybqpnzv", "jcaybqpnzv", "kcaybqpnzv", "lcaybqpnzv", "mcaybqpnzv", "ncaybqpnzv",
				"ocaybqpnzv", "pcaybqpnzv", "qcaybqpnzv", "rcaybqpnzv", "scaybqpnzv", "tcaybqpnzv", "ucaybqpnzv",
				"vcaybqpnzv", "wcaybqpnzv", "xcaybqpnzv", "ycaybqpnzv", "ydaybqpnzv", "adaybqpnzv", "bdaybqpnzv",
				"cdaybqpnzv", "ddaybqpnzv", "edaybqpnzv", "fdaybqpnzv", "gdaybqpnzv", "hdaybqpnzv", "idaybqpnzv",
				"jdaybqpnzv", "kdaybqpnzv", "ldaybqpnzv", "mdaybqpnzv", "ndaybqpnzv", "odaybqpnzv", "pdaybqpnzv",
				"qdaybqpnzv", "rdaybqpnzv", "sdaybqpnzv", "tdaybqpnzv", "udaybqpnzv", "vdaybqpnzv", "wdaybqpnzv",
				"xdaybqpnzv", "zdaybqpnzv", "zeaybqpnzv", "aeaybqpnzv", "beaybqpnzv", "ceaybqpnzv", "deaybqpnzv",
				"eeaybqpnzv", "feaybqpnzv", "geaybqpnzv", "heaybqpnzv", "ieaybqpnzv", "jeaybqpnzv", "keaybqpnzv",
				"leaybqpnzv", "meaybqpnzv", "neaybqpnzv", "oeaybqpnzv", "peaybqpnzv", "qeaybqpnzv", "reaybqpnzv",
				"seaybqpnzv", "teaybqpnzv", "ueaybqpnzv", "veaybqpnzv", "weaybqpnzv", "xeaybqpnzv", "yeaybqpnzv",
				"yfaybqpnzv", "afaybqpnzv", "bfaybqpnzv", "cfaybqpnzv", "dfaybqpnzv", "efaybqpnzv", "ffaybqpnzv",
				"gfaybqpnzv", "hfaybqpnzv", "ifaybqpnzv", "jfaybqpnzv", "kfaybqpnzv", "lfaybqpnzv", "mfaybqpnzv",
				"nfaybqpnzv", "ofaybqpnzv", "pfaybqpnzv", "qfaybqpnzv", "rfaybqpnzv", "sfaybqpnzv", "tfaybqpnzv",
				"ufaybqpnzv", "vfaybqpnzv", "wfaybqpnzv", "xfaybqpnzv", "zfaybqpnzv", "zgaybqpnzv", "agaybqpnzv",
				"bgaybqpnzv", "cgaybqpnzv", "dgaybqpnzv", "egaybqpnzv", "fgaybqpnzv", "ggaybqpnzv", "hgaybqpnzv",
				"igaybqpnzv", "jgaybqpnzv", "kgaybqpnzv", "lgaybqpnzv", "mgaybqpnzv", "ngaybqpnzv", "ogaybqpnzv",
				"pgaybqpnzv", "qgaybqpnzv", "rgaybqpnzv", "sgaybqpnzv", "tgaybqpnzv", "ugaybqpnzv", "vgaybqpnzv",
				"wgaybqpnzv", "xgaybqpnzv", "ygaybqpnzv", "yhaybqpnzv", "ahaybqpnzv", "bhaybqpnzv", "chaybqpnzv",
				"dhaybqpnzv", "ehaybqpnzv", "fhaybqpnzv", "ghaybqpnzv", "hhaybqpnzv", "ihaybqpnzv", "jhaybqpnzv",
				"khaybqpnzv", "lhaybqpnzv", "mhaybqpnzv", "nhaybqpnzv", "ohaybqpnzv", "phaybqpnzv", "qhaybqpnzv",
				"rhaybqpnzv", "shaybqpnzv", "thaybqpnzv", "uhaybqpnzv", "vhaybqpnzv", "whaybqpnzv", "xhaybqpnzv",
				"zhaybqpnzv", "ziaybqpnzv", "aiaybqpnzv", "biaybqpnzv", "ciaybqpnzv", "diaybqpnzv", "eiaybqpnzv",
				"fiaybqpnzv", "giaybqpnzv", "hiaybqpnzv", "iiaybqpnzv", "jiaybqpnzv", "kiaybqpnzv", "liaybqpnzv",
				"miaybqpnzv", "niaybqpnzv", "oiaybqpnzv", "piaybqpnzv", "qiaybqpnzv", "riaybqpnzv", "siaybqpnzv",
				"tiaybqpnzv", "uiaybqpnzv", "viaybqpnzv", "wiaybqpnzv", "xiaybqpnzv", "yiaybqpnzv", "yjaybqpnzv",
				"ajaybqpnzv", "bjaybqpnzv", "cjaybqpnzv", "djaybqpnzv", "ejaybqpnzv", "fjaybqpnzv", "gjaybqpnzv",
				"hjaybqpnzv", "ijaybqpnzv", "jjaybqpnzv", "kjaybqpnzv", "ljaybqpnzv", "mjaybqpnzv", "njaybqpnzv",
				"ojaybqpnzv", "pjaybqpnzv", "qjaybqpnzv", "rjaybqpnzv", "sjaybqpnzv", "tjaybqpnzv", "ujaybqpnzv",
				"vjaybqpnzv", "wjaybqpnzv", "xjaybqpnzv", "zjaybqpnzv", "zkaybqpnzv", "akaybqpnzv", "bkaybqpnzv",
				"ckaybqpnzv", "dkaybqpnzv", "ekaybqpnzv", "fkaybqpnzv", "gkaybqpnzv", "hkaybqpnzv", "ikaybqpnzv",
				"jkaybqpnzv", "kkaybqpnzv", "lkaybqpnzv", "mkaybqpnzv", "nkaybqpnzv", "okaybqpnzv", "pkaybqpnzv",
				"qkaybqpnzv", "rkaybqpnzv", "skaybqpnzv", "tkaybqpnzv", "ukaybqpnzv", "vkaybqpnzv", "wkaybqpnzv",
				"xkaybqpnzv", "ykaybqpnzv", "ylaybqpnzv", "alaybqpnzv", "blaybqpnzv", "claybqpnzv", "dlaybqpnzv",
				"elaybqpnzv", "flaybqpnzv", "glaybqpnzv", "hlaybqpnzv", "ilaybqpnzv", "jlaybqpnzv", "klaybqpnzv" };
		int[] groups = { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2,
				1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1,
				2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2,
				1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1,
				2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2,
				1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1,
				2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2,
				1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1,
				2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2,
				1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1,
				2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2,
				1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1,
				2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2,
				1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1,
				2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2,
				1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1,
				2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2,
				1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1,
				2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2,
				1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1,
				2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2,
				1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1,
				2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2,
				1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1,
				2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2,
				1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1,
				2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2,
				1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1,
				2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2 };

		List<Integer> res = solve(n, words, groups, n - 1, new ArrayList<>());
		List<String> val = new ArrayList<>();
		for (int i = res.size() - 1; i >= 0; i--) {
			val.add(words[res.get(i)]);
		}

		System.out.println(val);
	}

	private static List<Integer> solve(int n, String[] words, int[] groups, int sizeWords, List<Integer> ret) {
		if (sizeWords < 0) {
			return ret;
		}

		if (ret.size() == 0 || (groups[ret.get(ret.size() - 1)] != groups[sizeWords]
				&& isHammingOne(words[ret.get(ret.size() - 1)], words[sizeWords]))) {
			ret.add(sizeWords);
			List<Integer> liya = new ArrayList<>(solve(n, words, groups, sizeWords - 1, ret));
			ret.remove(ret.size() - 1);
			List<Integer> naiLiya = new ArrayList<>(solve(n, words, groups, sizeWords - 1, ret));
			return liya.size() >= naiLiya.size() ? liya : naiLiya;

		}

		return solve(n, words, groups, sizeWords - 1, ret);

	}

	private static boolean isHammingOne(String first, String second) {
		if (first.length() != second.length()) {
			return false;
		}
		int len = first.length();
		int charLen = 0;
		for (int i = 0; i < len; i++) {
			if (first.charAt(i) != second.charAt(i)) {
				charLen++;
				if (charLen > 1) {
					return false;
				}
			}
		}

		return charLen == 1;
	}

}
