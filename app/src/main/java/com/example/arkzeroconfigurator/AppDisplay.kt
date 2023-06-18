package com.example.arkzeroconfigurator


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.arkzeroconfigurator.ui.theme.ArkzeroConfiguratorTheme
import com.example.arkzeroconfigurator.ui.theme.rratFontFamily

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppDisplay(
    appViewModel: AppViewModel = viewModel()
){
    val appUiState by appViewModel.uiState.collectAsState()

    val header = painterResource(id = R.drawable.header)
    val sHeader = painterResource(id = R.drawable.headershort)




    // icons ----------------------------------------------------------------------------------
    val iconId = appViewModel.iconId
    val icon0: Int = when(iconId){
        0 -> R.drawable.b_trim
        else -> R.drawable.w_trim
    }

    val icon1: Int = when(iconId){
        1 -> R.drawable.b_paint
        else -> R.drawable.w_paint
    }

    val icon2: Int = when(iconId){
        2 -> R.drawable.b_wheels
        else -> R.drawable.w_wheels
    }

    val icon3: Int = when(iconId){
        3 -> R.drawable.b_interior
        else -> R.drawable.w_interior
    }

    val icon4: Int = when(iconId){
        4 -> R.drawable.b_packages
        else -> R.drawable.w_packages
    }

    val icon5: Int = when(iconId){
        5 -> R.drawable.b_summary
        else -> R.drawable.w_summary
    }

    // menu codes --------------------------------------------------------------------------
    val trimCode = appViewModel.trimId
    val colorCode = appViewModel.paintId
    val interiorCode = appViewModel.interiorId
    val wheelCode = when(trimCode){
        'c' -> 'a'
        'p' -> 'b'
        'g' -> 'c'
        'z' -> 'd'
        'x' -> 'e'
        else -> 'o'
    }
    // val mainCode: Array<Char> = arrayOf(trimCode, colorCode, wheelCode, interiorCode)


    // Price, name and Image -------------------------------------------------------
    val trimPrice: Int = when(trimCode){
        'c' -> 72500
        'p' -> 79500
        'g' -> 92500
        'z' -> 126500
        'x' -> 165500
        else -> -1
    }

    val colorPrice: Int = when(colorCode){
        'w', 'j' -> 0
        's', 'k', 'm', 'o', 'g', 'b' -> 1100
        'a', 'r' -> 2200
        'x' -> 3100
        else -> -1
    }

    val interiorPrice: Int = when(interiorCode){
        'c', 'g' -> 0
        'r', 't', 'w' -> 2200
        'a' -> 4200
        'b', 'd' -> 5200
        else -> -1
    }

    val price: Int = trimPrice + colorPrice + interiorPrice

    val trimName: String = when(trimCode){
        'c' -> "Core"
        'p' -> "Progressive"
        'g' -> "GT Pro"
        'z' -> "GT Performance"
        'x' -> "GT Performance e4X"
        else -> "BMW XM"
    }

    val imgCodeArr: CharArray = charArrayOf(trimCode, colorCode, wheelCode)
    val imgCode: String = String(imgCodeArr)
    //val imgCode: String = "pab",

    val img1: Int = when(imgCode){

        // Core
        "caa" -> R.drawable.caa1
        "cba" -> R.drawable.cba1
        "cga" -> R.drawable.cga1
        "cja" -> R.drawable.cja1
        "cka" -> R.drawable.cka1
        "cma" -> R.drawable.cma1
        "coa" -> R.drawable.coa1
        "cra" -> R.drawable.cra1
        "csa" -> R.drawable.csa1
        "cwa" -> R.drawable.cwa1
        "cxa" -> R.drawable.cxa1

        // Progressive
        "pab" -> R.drawable.pab1
        "pbb" -> R.drawable.pbb1
        "pgb" -> R.drawable.pgb1
        "pjb" -> R.drawable.pjb1
        "pkb" -> R.drawable.pkb1
        "pmb" -> R.drawable.pmb1
        "pob" -> R.drawable.pob1
        "prb" -> R.drawable.prb1
        "psb" -> R.drawable.psb1
        "pwb" -> R.drawable.pwb1
        "pxb" -> R.drawable.pxb1

        // GT Pro
        "gac" -> R.drawable.gac1
        "gbc" -> R.drawable.gbc1
        "ggc" -> R.drawable.ggc1
        "gjc" -> R.drawable.gjc1
        "gkc" -> R.drawable.gkc1
        "gmc" -> R.drawable.gmc1
        "goc" -> R.drawable.goc1
        "grc" -> R.drawable.grc1
        "gsc" -> R.drawable.gsc1
        "gwc" -> R.drawable.gwc1
        "gxc" -> R.drawable.gxc1

        // GT Performance
        "zad" -> R.drawable.zad1
        "zbd" -> R.drawable.zbd1
        "zgd" -> R.drawable.zgd1
        "zjd" -> R.drawable.zjd1
        "zkd" -> R.drawable.zkd1
        "zmd" -> R.drawable.zmd1
        "zod" -> R.drawable.zod1
        "zrd" -> R.drawable.zrd1
        "zsd" -> R.drawable.zsd1
        "zwd" -> R.drawable.zwd1
        "zxd" -> R.drawable.zxd1

        // GT Performance e4X
        "xae" -> R.drawable.xae1
        "xbe" -> R.drawable.xbe1
        "xge" -> R.drawable.xge1
        "xje" -> R.drawable.xje1
        "xke" -> R.drawable.xke1
        "xme" -> R.drawable.xme1
        "xoe" -> R.drawable.xoe1
        "xre" -> R.drawable.xre1
        "xse" -> R.drawable.xse1
        "xwe" -> R.drawable.xgw1
        "xxe" -> R.drawable.xxe1

        else -> R.drawable.g
    }


    val img2: Int = when(imgCode){

        // Core
        "caa" -> R.drawable.caa2
        "cba" -> R.drawable.cba2
        "cga" -> R.drawable.cga2
        "cja" -> R.drawable.cja2
        "cka" -> R.drawable.cka2
        "cma" -> R.drawable.cma2
        "coa" -> R.drawable.coa2
        "cra" -> R.drawable.cra2
        "csa" -> R.drawable.csa2
        "cwa" -> R.drawable.cwa2
        "cxa" -> R.drawable.cxa2

        // Progressive
        "pab" -> R.drawable.pab2
        "pbb" -> R.drawable.pbb2
        "pgb" -> R.drawable.pgb2
        "pjb" -> R.drawable.pjb2
        "pkb" -> R.drawable.pkb2
        "pmb" -> R.drawable.pmb2
        "pob" -> R.drawable.pob2
        "prb" -> R.drawable.prb2
        "psb" -> R.drawable.psb2
        "pwb" -> R.drawable.pwb2
        "pxb" -> R.drawable.pxb2

        // GT Pro
        "gac" -> R.drawable.gac2
        "gbc" -> R.drawable.gbc2
        "ggc" -> R.drawable.ggc2
        "gjc" -> R.drawable.gjc2
        "gkc" -> R.drawable.gkc2
        "gmc" -> R.drawable.gmc2
        "goc" -> R.drawable.goc2
        "grc" -> R.drawable.grc2
        "gsc" -> R.drawable.gsc2
        "gwc" -> R.drawable.gwc2
        "gxc" -> R.drawable.gxc2

        // GT Performance
        "zad" -> R.drawable.zad2
        "zbd" -> R.drawable.zbd2
        "zgd" -> R.drawable.zgd2
        "zjd" -> R.drawable.zjd2
        "zkd" -> R.drawable.zkd2
        "zmd" -> R.drawable.zmd2
        "zod" -> R.drawable.zod2
        "zrd" -> R.drawable.zrd2
        "zsd" -> R.drawable.zsd2
        "zwd" -> R.drawable.zwd2
        "zxd" -> R.drawable.zxd2

        // GT Performance e4X
        "xae" -> R.drawable.xae2
        "xbe" -> R.drawable.xbe2
        "xge" -> R.drawable.xge2
        "xje" -> R.drawable.xje2
        "xke" -> R.drawable.xke2
        "xme" -> R.drawable.xme2
        "xoe" -> R.drawable.xoe2
        "xre" -> R.drawable.xre2
        "xse" -> R.drawable.xse2
        "xwe" -> R.drawable.xgw2
        "xxe" -> R.drawable.xxe2

        else -> R.drawable.g
    }

    // Interior 1
    val img3: Int = when(interiorCode){
        'c' -> R.drawable.cloth1
        'b' -> R.drawable.blue1
        'g' -> R.drawable.check1
        'a' -> R.drawable.carbon1
        'r' -> R.drawable.red1
        'd' -> R.drawable.sus1
        't' -> R.drawable.tan1
        'w' -> R.drawable.white1
        else -> R.drawable.g
    }

    // Interior 2
    val img4: Int = when(interiorCode){
        'c' -> R.drawable.cloth2
        'b' -> R.drawable.blue2
        'g' -> R.drawable.check2
        'a' -> R.drawable.carbon2
        'r' -> R.drawable.red2
        'd' -> R.drawable.sus2
        't' -> R.drawable.tan2
        'w' -> R.drawable.white2
        else -> R.drawable.g
    }

    val imgGal = arrayOf(img1, img2, img3, img4)

    @Composable
    fun paint0() = Image(
        painter = painterResource(id = R.drawable.purewhite),
        contentDescription = "",
        modifier = Modifier
            .clickable {
                appViewModel.updatePaint('w')
            }
            .height(120.dp)
            .fillMaxWidth()
            .padding(5.dp)
    )
    @Composable
    fun paint1() = Image(
        painter = painterResource(id = R.drawable.jetblack),
        contentDescription = "",
        modifier = Modifier
            .clickable {
                appViewModel.updatePaint('j')
            }
            .height(120.dp)
            .fillMaxWidth()
            .padding(5.dp)
    )
    @Composable
    fun paint2() = Image(
        painter = painterResource(id = R.drawable.knightssilver),
        contentDescription = "",
        modifier = Modifier
            .clickable {
                appViewModel.updatePaint('k')
            }
            .height(120.dp)
            .fillMaxWidth()
            .padding(5.dp)
    )
    @Composable
    fun paint3() = Image(
        painter = painterResource(id = R.drawable.stormgray),
        contentDescription = "",
        modifier = Modifier
            .clickable {
                appViewModel.updatePaint('g')
            }
            .height(120.dp)
            .fillMaxWidth()
            .padding(5.dp)
    )
    @Composable
    fun paint4() = Image(
        painter = painterResource(id = R.drawable.mysticred),
        contentDescription = "",
        modifier = Modifier
            .clickable {
                appViewModel.updatePaint('m')
            }
            .height(120.dp)
            .fillMaxWidth()
            .padding(5.dp)
    )
    @Composable
    fun paint5() = Image(
        painter = painterResource(id = R.drawable.orientteal),
        contentDescription = "",
        modifier = Modifier
            .clickable {
                appViewModel.updatePaint('o')
            }
            .height(120.dp)
            .fillMaxWidth()
            .padding(5.dp)
    )
    @Composable
    fun paint6() = Image(
        painter = painterResource(id = R.drawable.supersonicblue),
        contentDescription = "",
        modifier = Modifier
            .clickable {
                appViewModel.updatePaint('b')
            }
            .height(120.dp)
            .fillMaxWidth()
            .padding(5.dp)
    )
    @Composable
    fun paint7() = Image(
        painter = painterResource(id = R.drawable.clearsky),
        contentDescription = "",
        modifier = Modifier
            .clickable {
                appViewModel.updatePaint('s')
            }
            .height(120.dp)
            .fillMaxWidth()
            .padding(5.dp)
    )
    @Composable
    fun paint8() = Image(
        painter = painterResource(id = R.drawable.armetallic),
        contentDescription = "",
        modifier = Modifier
            .clickable {
                appViewModel.updatePaint('a')
            }
            .height(120.dp)
            .fillMaxWidth()
            .padding(5.dp)
    )
    @Composable
    fun paint9() = Image(
        painter = painterResource(id = R.drawable.remetallic),
        contentDescription = "",
        modifier = Modifier
            .clickable {
                appViewModel.updatePaint('r')
            }
            .height(120.dp)
            .fillMaxWidth()
            .padding(5.dp)
    )
    @Composable
    fun paint10() = Image(
        painter = painterResource(id = R.drawable.alchemistsblue),
        contentDescription = "",
        modifier = Modifier
            .clickable {
                appViewModel.updatePaint('x')
            }
            .height(120.dp)
            .fillMaxWidth()
            .padding(5.dp)
    )

    val wheel0 = when(wheelCode){
        'a' -> R.drawable.wheel1
        else -> R.drawable.wheel1alt
    }

    val wheel1 = when(wheelCode){
        'b' -> R.drawable.wheel2
        else -> R.drawable.wheel2alt
    }

    val wheel2 = when(wheelCode){
        'c' -> R.drawable.wheel3
        else -> R.drawable.wheel3alt
    }

    val wheel3 = when(wheelCode){
        'd' -> R.drawable.wheel4
        else -> R.drawable.wheel4alt
    }

    val wheel4 = when(wheelCode){
        'e' -> R.drawable.wheel5
        else -> R.drawable.wheel5alt
    }

    @Composable
    fun wheel0() = Image(
        painter = painterResource(id = wheel0),
        contentDescription = "",
        modifier = Modifier
            .clickable {

            }
            .height(160.dp)
            .fillMaxWidth()
            .padding(5.dp)
    )

    @Composable
    fun wheel1() = Image(
        painter = painterResource(id = wheel1),
        contentDescription = "",
        modifier = Modifier
            .clickable {

            }
            .height(160.dp)
            .fillMaxWidth()
            .padding(5.dp)
    )

    @Composable
    fun wheel2() = Image(
        painter = painterResource(id = wheel2),
        contentDescription = "",
        modifier = Modifier
            .clickable {

            }
            .height(160.dp)
            .fillMaxWidth()
            .padding(5.dp)
    )

    @Composable
    fun wheel3() = Image(
        painter = painterResource(id = wheel3),
        contentDescription = "",
        modifier = Modifier
            .clickable {

            }
            .height(160.dp)
            .fillMaxWidth()
            .padding(5.dp)
    )

    @Composable
    fun wheel4() = Image(
        painter = painterResource(id = wheel4),
        contentDescription = "",
        modifier = Modifier
            .clickable {

            }
            .height(160.dp)
            .fillMaxWidth()
            .padding(5.dp)
    )


    @Composable
    fun spacerS() = Image(
        painter = painterResource(id = R.drawable.spacers),
        modifier = Modifier.height(40.dp),
        contentDescription = ""
    )

    @Composable
    fun spacerL() = Image(
        painter = painterResource(id = R.drawable.spacerl),
        modifier = Modifier.height(400.dp),
        contentDescription = ""
    )

    @Composable
    fun paintFunc(id: Int){
        val paintList = listOf(paint0(), paint1(), spacerS(), paint2(), paint3(), paint4(), paint5(), paint6(), paint7(), spacerS(), paint8(), paint9(), spacerS(), paint10(), spacerL())
        paintList[id]
    }

    @Composable
    fun wheelFunc(id: Int){
        val wheelList = listOf(wheel0(), wheel1(), wheel2(), wheel3(), wheel4(), spacerL())
        wheelList[id]
    }

    @Composable
    fun paintScroller(
        modifier: Modifier = Modifier.fillMaxWidth()
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            items(15){
                idx -> paintFunc(id = idx)
            }
        }
    }

    @Composable
    fun wheelScroller(
        modifier: Modifier = Modifier.fillMaxWidth()
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            items(6){
                    idx -> wheelFunc(id = idx)
            }
        }
    }


    @Composable
    fun mainScroller() = when(iconId){
        1 -> paintScroller(Modifier.fillMaxWidth())
        2 -> wheelScroller(Modifier.fillMaxWidth())
        else -> {}
    }




    // APP LAYOUT ---------------------------------------------------------

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        // header
        Image(painter = sHeader, contentDescription = "")
        Spacer(modifier = Modifier.height(0.dp))


        // Trim level
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "TRIM LEVEL |",
                style = TextStyle(
                    fontFamily = rratFontFamily,
                    fontWeight = FontWeight.W300,
                    fontSize = 12.sp,
                    //letterSpacing = 0.5.sp
                ),
                textAlign = TextAlign.Center
            )

            Text(
                text = "  $trimName",
                style = TextStyle(
                    fontFamily = rratFontFamily,
                    fontWeight = FontWeight.W400,
                    fontSize = 18.sp,
                    //letterSpacing = 0.5.sp
                ),
                textAlign = TextAlign.Center
            )

        }

        // Price
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "MSRP As Built",
            style = TextStyle(
                fontFamily = rratFontFamily,
                fontWeight = FontWeight.W400,
                fontSize = 10.sp,
                //letterSpacing = 0.5.sp
            ),
            textAlign = TextAlign.Center
        )
        // Spacer(modifier = Modifier.height(0.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$ ",
                style = TextStyle(
                    fontFamily = rratFontFamily,
                    fontWeight = FontWeight.W200,
                    fontSize = 18.sp,
                    //letterSpacing = 0.5.sp
                ),
                textAlign = TextAlign.Center
            )

            Text(
                text = "%,d".format(price),
                style = TextStyle(
                    fontFamily = rratFontFamily,
                    fontWeight = FontWeight.W200,
                    fontSize = 28.sp,
                    //letterSpacing = 0.5.sp
                ),
                textAlign = TextAlign.Center
            )
        }

        // Main image
        Spacer(modifier = Modifier.height(15.dp))

        val pagerState = rememberPagerState()

        Box() {
            HorizontalPager(
                pageCount = imgGal.size,
                state = pagerState,
                key = { imgGal[it] },
                pageSize = PageSize.Fill
            ) { index ->
                Image(
                    painter = painterResource(id = imgGal[index]),
                    contentDescription = "Pictures of the views of the car",
                )
            }
        }

        // Dots
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            Modifier
                .height(25.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(imgGal.size) { iteration ->
                val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)

                )
            }
        }

        // Navbar
        Spacer(modifier = Modifier.height(0.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically

        ){
            Image(
                painter = painterResource(id = icon0),
                contentDescription = "Button for selecting the trim level",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        appViewModel.updateNavbar(0)
                    }
            )
            //Spacer(modifier = Modifier.width(5.dp))

            Image(
                painter = painterResource(id = icon1),
                contentDescription = "Button for selecting the trim level",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        appViewModel.updateNavbar(1)
                    }

            )
            //Spacer(modifier = Modifier.width(5.dp))
            Image(
                painter = painterResource(id = icon2),
                contentDescription = "Button for selecting the trim level",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        appViewModel.updateNavbar(2)
                    }
            )
            //Spacer(modifier = Modifier.width(5.dp))
            Image(
                painter = painterResource(id = icon3),
                contentDescription = "Button for selecting the trim level",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        appViewModel.updateNavbar(3)
                    }
            )
            //Spacer(modifier = Modifier.width(5.dp))
            Image(
                painter = painterResource(id = icon4),
                contentDescription = "Button for selecting the trim level",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        appViewModel.updateNavbar(4)
                    }
            )
            Spacer(modifier = Modifier.width(3.dp))
            Text(text = "|", style = TextStyle(fontSize = 25.sp))
            Spacer(modifier = Modifier.width(3.dp))
            Image(
                painter = painterResource(id = icon5),
                contentDescription = "Button for selecting the trim level",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        appViewModel.updateNavbar(5)
                    }
            )
        }

        Image(painter = painterResource(id = R.drawable.rectangle_8),
            contentDescription = "",
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        mainScroller()



    }
}



@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    ArkzeroConfiguratorTheme() {
        AppDisplay()
    }
}