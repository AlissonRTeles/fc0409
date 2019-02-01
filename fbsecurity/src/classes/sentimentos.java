/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lipe_
 */
public class sentimentos {
    
    int cont=0;
    String alegria_base[] = {"rsrs","kkk","hehe","haha","kkk","hue", " abundante ",	" acalmar ",	" aceitavel ",	" aclamar ",	" aconchego ",	" adesao ",	" admirar ",	" adorar ",	" afavel ",	" afeicao ",	" afeto ",	" afortunado ",	" agradar ",	" ajeitar ",	" alivio ",	" amabilidade ",	" amado ",	" amar ",	" amavel ",	" amenizar ",	" ameno ",	" amigavel ",	" amistoso ",	" amizade ",	" amor ",	" animacao ",	" animo ",	" apaixonado ",	" apaziguar ",	" aplausos ",	" apoiar ",	" aprazer ",	" apreciar ",	" aprovacao ",	" armirar ",	" atracao ",	" atraente ",	" atrair ",	" avidamente ",	" avidez ",	" avido ",	" belo ",	" beneficencia ",	" beneficiador ",	" benevocencia ",	" benignamente ",	" benigno ",	" bondade ",	" bondoso ",	" brilhante ",	" brincadeira ",	" calma ",	" calor ",	" caridade ",	" caridoso ",	" carinho ",	" cativar ",	" charme ",	" cheery ",	" clamar ",	" cofortar ",	" coleguismo ",	" comedia ",	" comico ",	" comover ",	" compaixao ",	" companheirismo "," complacencia ",	" completar ",	" compreensao ",	" concretizacao ",	" condescendencia ",	" confianca ",	" confortante ",	" congratulacao ",	" conquistar ",	" consentir ",	" consideracao ",	" consolacao ",	" contentamento ",	" cordial ",	" considerar ",	" consolo ",	" contente ",	" cuidadoso ",	" cumplicidade ",	" dedicacao ",	" deleitado ",	" delicadamente ",	" delicadeza ",	" delicado ",	" diversao ",	" divertido ",	" encantar ",	" elogiado ",	" emocao ",	" emocionante ",	" emotivo ",	" empatia ",	" empatico ",	" empolgacao ",	" enamorar ",	" encantado ",	" encorajado ",	" enfeitar ",	" engracado ",	" entusiasmadamente ",	" entusiastico ",	" esperanca ",	" esplendor ",	" estima ",	" estimar ",	" estimulante ",	" euforia ",	" euforico ",	" euforizante ",	" exaltar ",	" excitar ",	" expansivo ",	" extasiar ",	" exuberante ",	" exultar ",	" fa ",	" fascinacao ",	" fascinio ",	" favorecer ",	" favorito ",	" felicidade ",	" feliz ",	" festa ",	" festejar ",	" festivo ",	" fidelidade ",	" fiel ",	" filantropia ",	" filantropico ",	" fraterno ",	" ganhar ",	" generosidade ",	" generoso ",	" gentil ",	" gloria ",	" glorificar ",	" gostar ",	" gostoso ",	" gozar ",	" gratificante ",	" hilariante ",	" honra ",	" humor ",	" impressionar ",	" incentivar ",	" incentivo ",	" inclinacao ",	" incrivel ",	" inspirar ",	" irmandade ",	" jovial ",	" jubilante ",	" júbilo ",	" lealdade ",	" legitimo ",	" leveza ",	" louvar ",	" louvavel ",	" louvavelmente ",	" lucrativo ",	" lucro ",	" maravilhoso ",	" obter ",	" obteve ",	" ode ",	" orgulho ",	" paixao ",	" parabenizar ",	" paz ",	" piedoso ",	" prazenteiro ",	" prazer ",	" predilecao ",	" preencher ",	" preferencia ",	" preferido ",	" promissor ",	" prosperidade ",	" protecao ",	" protetor ",	" proveito ",	" provilegio ",	" querer ",	" radiante ",	" recomendavel ",	" reconhecer ",	" recompensa ",	" recrear ",	" recreativo ",	" recreacao ",	" regozijar ",	" respeitar ",	" ressuscitar ",	" revigorar ",	" risada ",	" risonho ",	" romantico ",	" romantismo ",	" saciar ",	" saciavel ",	" satisfatoriamente ",	" satisfatorio ",	" satisfazer ",	" satisfeito ",	" seducao ",	" seduzir ",	" simpaticamente ",	" simpatico ",	" sobrevivencia ",	" sobreviver ",	" sorte ",	" sortudo ",	" sucesso ",	" surpreender ",	" tenro ",	" ternura ",	" torcer ",	" triunfo ",	" triunfal ",	" triunfante ",	" vantagem ",	" vantajoso ",	" vencedor ",	" veneracao ",	" ventura ",	" virtuoso ",	" vitoria ",	" vitorioso ",	" viver "};
    String desgosto_base[] = {" abominavel ",	" adoentado ",	" amargamente ",	" antipatia ",	" antipatico ",	" asco ",	" asqueroso ",	" aversao ",	" chateacao ",	" chatear ",	" desagradavel ",	" desagrado ",	" desprezivel ",	" detestavel ",	" doenca ",	" doente ",	" enfermidade ",	" enjoativo ",	" enjoo ",	" enjoo ",	" feio ",	" fetido ",	" golfar ",	" grave ",	" gravidade ",	" grosseiro ",	" grosso ",	" horrivel ",	" ignobil ",	" ilegal ",	" incomdo ",	" incomodar ",	" indecente ",	" indisposicao ",	" indisposto ",	" inescrupuloso ",	" maldade ",	" maldoso ",	" malvado ",	" mau ",	" nausea ",	" nauseabundo ",	" nauseante ",	" nausear ",	" nauseoso ",	" nojento ",	" nojo ",	" obsceno ",	" obstrucao ",	" obstruir ",	" ofensivo ",	" patetico ",	" perigoso ",	" repelente ",	" repelir ",	" repugnante ",	" repulsa ",	" repulsao ",	" repulsivo ",	" rude ",	" sujeira ",	" sujo ",	" terrivel ",	" terrivelmente ",	" torpe ",	" travesso ",	" travessura ",	" ultrajante ",	" vil ",	" vomitar ",	" vomito "};
    String medo_base[] = {" medo "," abominavel ",	" afugentar ",	" alarmar ",	" alerta ",	" ameaca ",	" amedrontar ",	" angustia ",	" angustia ",	" angustiadamente ",	" ansiedade ",	" ansioso ",	" apavorar ",	" apreender ",	" apreensao ",	" apreensivo ",	" arrepio ",	" assombrado ",	" assombro ",	" assustado ",	" assustadoramente ",	" atemorizar ",	" aterrorizante ",	" brutal ",	" calafrio ",	" chocado ",	" chocante ",	" consternado ",	" covarde ",	" cruel ",	" crueldade ",	" cruelmente ",	" cuidado ",	" cuidadosamente ",	" cuidadoso ",	" defender ",	" defensor ",	" defesa ",	" derrotar ",	" desconfiado ",	" desconfianca ",	" desencorajar ",	" desespero ",	" deter ",	" envergonhado ",	" escandalizado ",	" escuridao ",	" espantoso ",	" estremecedor ",	" estremecer ",	" expulsar ",	" feio ",	" friamente ",	" fugir ",	" hesitar ",	" horrendo ",	" horripilante ",	" horrivel ",	" horrivelmente ",	" horror ",	" horrorizar ",	" impaciencia ",	" impaciente ",	" impiedade ",	" impiedoso ",	" indecisao ",	" inquieto ",	" inseguranca ",	" inseguro ",	" intimidar ",	" medonho ",	" medroso ",	" monstruosamente ",	" mortalha ",	" nervoso ",	" panico ",	" pavor ",	" premonicao ",	" preocupar ",	" pressagio ",	" pressentimento ",	" recear ",	" receativamente ",	" receio ",	" receoso ",	" ruim ",	" suspeita ",	" suspense ",	" susto ",	" temer ",	" temeroso ",	" temor ",	" tensao ",	" tenso ",	" terrificar ",	" terrivel ",	" terrivelmente ",	" terror ",	" timidamente ",	" timidez ",	" timido ",	" tremor ",	" vigiar ",	" vigilante "};
    String raiva_base[] = {" raiva "," abominacao ",	" aborrecer ",	" adredido ",	" agredir ",	" agressao ",	" agressivo ",	" amaldicoado ",	" amargor ",	" amargura ",	" amolar ",	" angustia ",	" animosidade ",	" antipatia ",	" antipatico ",	" asco ",	" assassinar ",	" assassinato ",	" assediar ",	" assedio ",	" atormentar ",	" avarento ",	" avareza ",	" aversao ",	" beligerante ",	" bravejar ",	" chateacao ",	" chato ",	" cobicoso ",	" colera ",	" colerico ",	" complicar ",	" contraiedade ",	" contrariar ",	" corrupcao ",	" corrupto ",	" cruxificar ",	" demoniaco ",	" demonio ",	" descaso ",	" descontente ",	" descontrole ",	" desenganar ",	" desgostar ",	" desgraca ",	" desprazer ",	" desprezar ",	" destruicao ",	" destruir ",	" detestar ",	" diabo ",	" diabolico ",	" doido ",	" encolerizar ",	" energicamente ",	" enfurecido ",	" enfuriante ",	" enlouquecer ",	" enraivecer ",	" escandalizar ",	" escandalo ",	" escoriar ",	" exasperar ",	" execracao ",	" ferir ",	" frustracao ",	" frustrar ",	" furia ",	" furioso ",	" furor ",	" ganancia ",	" ganancioso ",	" guerra ",	" guerreador ",	" guerrilha ",	" hostil ",	" humilhar ",	" implicancia ",	" implicar ",	" importunar ",	" incomodar ",	" incomodo ",	" indignar ",	" infernizar ",	" inimigo ",	" inimizade ",	" injuria ",	" injuriado ",	" injustica ",	" insulto ",	" inveja ",	" ira ",	" irado ",	" irascibilidade ",	" irascivel ",	" irritar ",	" louco ",	" loucura ",	" magoar ",	" mal ",	" maldade ",	" maldicao ",	" maldito ",	" maldizer ",	" maldoso ",	" maleficencia ",	" malefico ",	" malevolencia ",	" malevolo ",	" malicia ",	" malicioso ",	" malignidade ",	" maligno ",	" maltratar ",	" maluco ",	" malvadeza ",	" malvado ",	" matar ",	" mesquinho ",	" misantropia ",	" misantropico ",	" molestar ",	" molestia ",	" mortal ",	" morte ",	" mortifero ",	" mortificar ",	" nervoso ",	" odiar ",	" odiavel ",	" odio ",	" odioso ",	" ofendido ",	" ofensa ",	" opressao ",	" opressivo ",	" oprimir ",	" perseguicao ",	" perseguir ",	" perturbar ",	" perverso ",	" provocar ",	" rabugento ",	" raivoso ",	" rancor ",	" reclamar ",	" repressao ",	" reprimir ",	" repulsa ",	" repulsivo ",	" resmungar ",	" ressentido ",	" revolta ",	" ridiculo ",	" tempestuoso ",	" tirano ",	" tormento ",	" torturar ",	" ultrage ",	" ultrajar ",	" vexatorio ",	" vigoroso ",	" vinganca ",	" vingar ",	" vingativo ",	" violencia ",	" violento ",	" zangar "};
    String surpresa_base[] = {" surpresa "," admirar ",	" afeicao ",	" apavorante ",	" assombro ",	" chocado ",	" chocante ",	" desconcertar ",	" deslumbrar ",	" embasbacar ",	" emudecer ",	" encantamento ",	" enorme ",	" espanto ",	" estupefante ",	" estupefato ",	" estupefazer ",	" expectativa ",	" fantasticamente ",	" fantastico ",	" horripilante ",	" imaginario ",	" imenso ",	" impressionado ",	" incrivel ",	" maravilha ",	" milagre ",	" misterio ",	" misterioso ",	" otimo ",	" pasmo ",	" perplexo ",	" prodigio ",	" sensacional ",	" surpreendente ",	" surpreender ",	" suspense ",	" susto ",	" temor ",	" tremendo "};
    String tristeza_base[] = {" tristeza "," abandonar ",	" abatido ",	" abominavel ",	" aborrecer ",	" abortar ",	" aflicao ",	" afligir ",	" aflito ",	" agoniar ",	" amargo ",	" amargor ",	" amargura ",	" ansiedade ",	" arrepender ",	" arrependidamente ",	" atrito ",	" azar ",	" cabisbaixo ",	" chorao ",	" choro ",	" choroso ",	" coitado ",	" compassivo ",	" compuncao ",	" contricao ",	" contristador ",	" contrito ",	" culpa ",	" defeituoso ",	" degradante ",	" deploravel ",	" deposicao ",	" depravado ",	" depressao ",	" depressivo ",	" deprimente ",	" deprimir ",	" derrota ",	" derrubar ",	" desalentar ",	" desamparo ",	" desanimar ",	" desanimo ",	" desapontar ",	" desconsolo ",	" descontente ",	" desculpas ",	" desencorajar ",	" desespero ",	" desgaste ",	" desgosto ",	" desgraca ",	" desistencia ",	" desistir ",	" deslocado ",	" desmoralizar ",	" desolar ",	" desonra ",	" despojado ",	" desprazer ",	" desprezo ",	" desumano ",	" discriminar ",	" disforia ",	" disforico ",	" dissuadir ",	" do ",	" doloroso ",	" dor ",	" enfadado ",	" enlutar ",	" entediado ",	" entristecedor ",	" entristecer ",	" envergonhar ",	" errante ",	" erro ",	" erroneo ",	" escurecer ",	" escuridao ",	" escuro ",	" esquecido ",	" estragado ",	" execravel ",	" extirpar ",	" FALSO ",	" falsidade ",	" falta ",	" fraco ",	" fraqueza ",	" friccao ",	" frieza ",	" frio ",	" funebre ",	" funesto ",	" grave ",	" horror ",	" humilhar ",	" inconsolavel ",	" indefeso ",	" infelicidade ",	" infeliz ",	" infortunio ",	" isolar ",	" lacrimejante ",	" lacrimoso ",	" lagrima ",	" lamentar ",	" lastima ",	" lastimoso ",	" lugubre ",	" luto ",	" lutoso ",	" magoa ",	" magoar ",	" martirio ",	" martirizar ",	" mau ",	" melancolia ",	" melancolico ",	" menosprezar ",	" miseravelmente ",	" miseria ",	" misterio ",	" misterioso ",	" morre ",	" morte ",	" mortificante ",	" negligentemente ",	" nocivo ",	" obscuro ",	" opressao ",	" opressivo ",	" oprimir ",	" penalizar ",	" penitente ",	" penoso ",	" penumbra ",	" perder ",	" perturbado ",	" perverso ",	" pervertar ",	" pesaroso ",	" pessimamente ",	" piedade ",	" pobre ",	" porcamente ",	" prejudicado ",	" prejudicial ",	" prejuizo ",	" pressao ",	" pressionar ",	" quebrar ",	" queda ",	" queixoso ",	" rechacar ",	" remorso ",	" repressao ",	" repressivo ",	" reprimir ",	" ruim ",	" secreto ",	" servil ",	" so ",	" sobrecarga ",	" sobrecarregado ",	" sofrer ",	" sofrimento ",	" solidao ",	" sombrio ",	" soturno ",	" sujo ",	" suplicar ",	" suplicio ",	" tedio ",	" timidez ",	" timido ",	" torturar ",	" trevas ",	" triste ",	" tristemente ",	" vazio "};
    String palavrao_base[] = {" anus ",	" babaovo ",	" babaca ",	" bacura ",	" bagos ",	" baitola ",	" bebum ",	" besta ",	" bicha ",	" bisca ",	" bixa ",	" boazuda ",	" boceta ",	" boco ",	" boiola ",	" bolagato ",	" boquete ",	" bolcat ",	" bosseta ",	" bosta ",	" bostana ",	" brecha ",	" brexa ",	" brioco ",	" bronha ",	" buca ",	" buceta ",	" bunda ",	" bunduda ",	" burra ",	" burro ",	" busseta ",	" cachorra ",	" cachorro ",	" cadela ",	" caga ",	" cagado ",	" cagao ",	" cagona ",	" canalha ",	" caralho ",	" casseta ",	" cassete ",	" checheca ",	" chereca ",	" chibumba ",	" chibumbo ",	" chifruda ",	" chifrudo ",	" chota ",	" chochota ",	" chupada ",	" chupado ",	" clitoris ",	" cocaina ",	" coco ",	" corna ",	" corno ",	" cornuda ",	" cornudo ",	" corrupta ",	" corrupto ",	" cretina ",	" cretino ",	" cu ",	" culhao ",	" curalho ",	" cuzao ",	" cuzuda ",	" cuzudo ",	" debil ",	" debiloide ",	" defunto ",	" demonio ",	" difunto ",	" doida ",	" doido ",	" egua ",	" escrota ",	" escroto ",	" esporrada ",	" esporrado ",	" esporro ",	" estupida ",	" estupidez ",	" estupido ",	" fedida ",	" fedido ",	" fedor ",	" fedorenta ",	" feia ",	" feio ",	" feiosa ",	" feioso ",	" feioza ",	" feiozo ",	" felacao ",	" fenda ",	" foda ",	" fodao ",	" fod+o ",	" fode ",	" fodida ",	" fodido ",	" fornica ",	" fudendo ",	" fudecao ",	" fudida ",	" fudido ",	" furada ",	" furado ",	" furao ",	" furnica ",	" furnicar ",	" furo ",	" furona ",	" gaiata ",	" gaiato ",	" gay ",	" gonorrea ",	" gonorreia ",	" gosma ",	" gosmenta ",	" gosmento ",	" grelinho ",	" grelo ",	" homosexual ",	" homossexual ",	" idiota ",	" idiotice ",	" imbecil ",	" iscrota ",	" iscroto ",	" japa ",	" ladra ",	" ladrao ",	" ladroeira ",	" ladrona ",	" lalau ",	" leprosa ",	" leproso ",	" lesbica ",	" macaca ",	" macaco ",	" machona ",	" machorra ",	" manguaca ",	" masturba ",	" meleca ",	" merda ",	" mija ",	" mijada ",	" mijado ",	" mijo ",	" mocrea ",	" mocreia ",	" moleca ",	" moleque ",	" mondronga ",	" mondrongo ",	" naba ",	" nadega ",	" nojeira ",	" nojenta ",	" nojento ",	" nojo ",	" olhota ",	" otaria ",	" ot-ria ",	" otario ",	" paca ",	" paspalha ",	" paspalhao ",	" paspalho ",	" pau  ",	" peia ",	" peido ",	" pemba ",	" penis ",	" p-nis ",	" pentelha ",	" pentelho ",	" perereca ",	" peru ",	" pica ",	" picao ",	" pilantra ",	" piranha ",	" piroca ",	" piroco ",	" piru ",	" porra ",	" prega ",	" prostibulo ",	" prost-bulo ",	" prostituta ",	" prostituto ",	" punheta ",	" punhetao ",	" pus ",	" pustula ",	" puta ",	" puto ",	" puxa-saco ",	" puxasaco ",	" rabao ",	" rab+o ",	" rabo ",	" rabuda ",	" rabudao ",	" rabudo ",	" rabudona ",	" racha ",	" rachada ",	" rachadao ",	" rachadinha ",	" rachadinho ",	" rachado ",	" ramela ",	" remela ",	" retardada ",	" retardado ",	" ridicula ",	" rola ",	" rolinha ",	" rosca ",	" sacana ",	" safada ",	" safado ",	" sapatao ",	" sifilis ",	" s-filis ",	" siririca ",	" tarada ",	" tarado ",	" testuda ",	" tezao ",	" tezuda ",	" tezudo ",	" trocha ",	" trolha ",	" troucha ",	" trouxa ",	" troxa ",	" vaca ",	" vagabunda ",	" vagabundo ",	" vagina ",	" veada ",	" veadao ",	" veado ",	" viada ",	" viado ",	" viadao ",	" xavasca ",	" xerereca ",	" xexeca ",	" xibiu ",	" xibumba ",	" xota ",	" xochota ",	" xoxota ",	" xana ",	" xaninha "};
    String seguranca_base[] = {" conta ", " acesso ", " banco ", " credito ", " clique ", " identidade ", " inconveniencia ", " informacao ", " limitado "," registro "," minutos "," senha "," recentemente "," risco "," social "," seguranca "," servico "," suspendido ", " cartao "};

   
    
    
    
///////ALEGRIA//////////
    public int alegria(String alegria){
    cont=0;
        for(int i=0;i < alegria_base.length;i++)
        {
        if (alegria.contains(alegria_base[i]))
            {
                cont =cont + 1;
                //System.out.println(cont); 
                System.out.println(alegria_base[i]);
            }        
        }       
          //System.out.println(cont);    
        return cont;
    }

/////////////////DESGOSTO///////////
public int desgosto(String desgosto){
    cont=0;
        for(int i=0;i < desgosto_base.length;i++)
        {
        if (desgosto.contains(desgosto_base[i]))
            {
                cont =cont + 1;
                //System.out.println(cont); 
                //System.out.println(desgosto_base[i]);
            }        
        }       
         // System.out.println(cont);    
        return cont;
    }
/////////////////MEDO///////////
public int medo(String medo){
    cont=0;
        for(int i=0;i < medo_base.length;i++)
        {
        if (medo.contains(medo_base[i]))
            {
                cont =cont + 1;
                //System.out.println(cont); 
               //System.out.println(medo_base[i]);
            }        
        }       
         // System.out.println(cont);    
        return cont;
    }
/////////////////RAIVA///////////
public int raiva(String raiva){
    cont=0;
        for(int i=0;i < raiva_base.length;i++)
        {
        if (raiva.contains(raiva_base[i]))
            {
                cont =cont + 1;
                ///System.out.println(cont); 
               //System.out.println(raiva_base[i]);
            }        
        }       
         // System.out.println(cont);    
        return cont;
    }
/////////////////SURPRESA///////////
public int surpresa(String surpresa){
    cont=0;
        for(int i=0;i < surpresa_base.length;i++)
        {
        if (surpresa.contains(surpresa_base[i]))
            {
                cont =cont + 1;
                //System.out.println(cont); 
                //System.out.println(surpresa_base[i]);
            }        
        }       
          //System.out.println(cont);    
        return cont;
    }
/////////////////TRISTEZA///////////
public int tristeza(String tristeza){
    cont=0;
        for(int i=0;i < tristeza_base.length;i++)
        {
        if (tristeza.contains(tristeza_base[i]))
            {
                cont =cont + 1;
               //System.out.println(cont); 
               //System.out.println(tristeza_base[i]);
            }        
        }       
             
        return cont;
    }

///////PALAVROES//////////
    public int palavrao(String palavrao){
    cont=0;
        for(int i=0;i < palavrao_base.length;i++)
        {
        if (palavrao.contains(palavrao_base[i]))
            {
                cont =cont + 1;
               // System.out.println(palavrao_base[i]);
            }        
        }        
        return cont;
    }
    
    ///////FRAUDES//////////
    public int fraudes(String fraudes){
    cont=0;
        for(int i=0;i < seguranca_base.length;i++)
        {
        if (fraudes.contains(seguranca_base[i]))
            {
                cont =cont + 1;
               // System.out.println(seguranca_base[i]);
            }        
        }        
        return cont;
    }

}