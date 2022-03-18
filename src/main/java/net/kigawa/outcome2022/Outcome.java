package net.kigawa.outcome2022;

import com.github.lalyos.jfiglet.FigletFont;
import net.kigawa.kutil.app.ApplicationBase;
import net.kigawa.kutil.app.Option;
import net.kigawa.kutil.kutil.StringColor;

import java.io.IOException;
import java.util.List;

public class Outcome extends ApplicationBase {
    public static Outcome outcome;

    protected Outcome(String[] args) {
        super(args);
    }

    public static void main(String[] args) {
        outcome = new Outcome(args);
        outcome.enable();
    }

    private void readCmd(String cmd) {
        switch (cmd) {
            case "end" -> end();
            case "help" -> help();
            case "title" -> title();
            case "why" -> why();
            case "mind" -> mind();
            case "hard" -> hard();
            case "action" -> action();
            case "kvm" -> kvm();
            case "docker" -> docker();
            case "after" -> after();
            case "etc" -> etc();
        }
    }

    private void etc() {
        logger.info("このソフトは午前中に石川さんがwebページ作ったと聞いて5時間くらいで作った",
                "これ作ってて授業忘れた\n\n\n");
    }

    private void after() {
        logger.info("仮想化はITにおいて今後も使うことがあるだろうし、構築したことによって今後のサーバー管理が楽になる\n\n\n");

    }

    private void docker() {
        logger.info(
                StringColor.GREEN + "dockerとは?",
                "linuxの中心となるカーネルを共有したままホストに影響を及ぼすことのない",
                "仮想環境を提供するソフトウェア",
                "同じものを何回も作成したり消したりすることができるので気軽に消したり",
                "同じものを複数個効率よく作成することができる"
        );
    }

    private void kvm() {
        logger.info(
                StringColor.GREEN + "kvmとは?",
                "linuxのカーネルを使用した、仮想環境を作成することができるハイパーバイザ",
                "ホストの影響を受けることがなく、様々なOSを動かすことができ、",
                "分離されているのでホストに影響を与えることもない",
                "ゲストは普通のサーバーと同じように扱うことができる"
        );
    }

    private void action() {
        logger.info("kvmとdocker構築した\n\n\n");

    }

    private void hard() {
        logger.info("日本語ほとんどがなかったor古かった\n\n\n");

    }

    private void mind() {
        logger.info("新しいものを触るのは楽しかった\n\n\n");

    }

    private void why() {
        logger.info("test環境が欲しい、貸し出したい\n\n\n");
    }

    private void title() {
        try {
            logger.info("\n" + StringColor.GREEN + FigletFont.convertOneLine("kvm  and  docker"));
        } catch (IOException e) {
            logger.warning(e);
        }
    }

    private void help() {
        logger.info(StringColor.GREEN + "_Index_",
                "title  " + StringColor.BLUE + " > " + StringColor.RESET + "タイトル",
                "why    " + StringColor.BLUE + " > " + StringColor.RESET + "きっかけ・動機",
                "mind   " + StringColor.BLUE + " > " + StringColor.RESET + "気持ち",
                "hard   " + StringColor.BLUE + " > " + StringColor.RESET + "大変だったこと",
                "action " + StringColor.BLUE + " > " + StringColor.RESET + "行動",
                "kvm    " + StringColor.BLUE + " > " + StringColor.RESET + "kvmとは",
                "docker " + StringColor.BLUE + " > " + StringColor.RESET + "dockerとは",
                "after  " + StringColor.BLUE + " > " + StringColor.RESET + "今後に行かせること",
                "etc    " + StringColor.BLUE + " > " + StringColor.RESET + "余談",
                "end    " + StringColor.BLUE + " > " + StringColor.RESET + "エンディング"
        );
    }

    private void end() {
        try {
            logger.info("\n" + FigletFont.convertOneLine("Thank you!"));
        } catch (IOException e) {
            logger.warning(e);
        }
        disable();
    }

    @Override
    protected void addAllOpt(List<Option> list) {

    }

    @Override
    protected void onDisable() {

    }

    @Override
    protected void onEnable() {
        terminal.addOnRead(this::readCmd);
        try {
            logger.info("\n" + FigletFont.convertOneLine("My Outcome!"));
        } catch (IOException e) {
            logger.warning(e);
        }
    }
}
