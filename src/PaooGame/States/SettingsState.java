package PaooGame.States;

import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.Graphics.AudioLoader;
import PaooGame.Handler;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIManager;
import PaooGame.Utils.UIImageButton;

import java.awt.*;
import java.sql.SQLException;

public class SettingsState extends State {

    private UIManager uiManager;

    public SettingsState(Handler handler) {

        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton(752, 40, 48, 48, Assets.btn_back, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(uiManager);
                State.setState(handler.getGame().introState);
            }
        }));

    }

    @Override
    public void update() {
        System.out.println(handler.getMouseManager().getMouseX() + " " + handler.getMouseManager().getMouseY());
        uiManager.update();

        if (handler.getMouseManager().getMouseX() >= 692 && handler.getMouseManager().getMouseX() <= 722) {
            if (handler.getMouseManager().getMouseY() >= 223 && handler.getMouseManager().getMouseY() <= 254) {
                if (handler.getMouseManager().isLeftPressed()) {
                    try {
                        if (handler.getDataBase().getMenuVolume() == 100) {
                            handler.getDataBase().updateMenuMusicVolume(0);
                        } else {
                            handler.getDataBase().updateMenuMusicVolume(handler.getDataBase().getMenuVolume() + 10);
                        }
                        AudioLoader.setVolume(Assets.menuMusic, handler.getDataBase().getMenuVolume());
                        Thread.sleep(100);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if (handler.getMouseManager().getMouseX() >= 739 && handler.getMouseManager().getMouseX() <= 768) {
            if (handler.getMouseManager().getMouseY() >= 224 && handler.getMouseManager().getMouseY() <= 254) {
                if (handler.getMouseManager().isLeftPressed()) {
                    try {
                        if (handler.getDataBase().getMenuVolume() == 0) {
                            handler.getDataBase().updateMenuMusicVolume(100);
                        } else {
                            handler.getDataBase().updateMenuMusicVolume(handler.getDataBase().getMenuVolume() - 10);
                        }
                        AudioLoader.setVolume(Assets.menuMusic, handler.getDataBase().getMenuVolume());
                        Thread.sleep(100);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        if (handler.getMouseManager().getMouseX() >= 692 && handler.getMouseManager().getMouseX() <= 719) {
            if (handler.getMouseManager().getMouseY() >= 278 && handler.getMouseManager().getMouseY() <= 310) {
                if (handler.getMouseManager().isLeftPressed()) {
                    try {
                        if (handler.getDataBase().getGameVolume() == 100) {
                            handler.getDataBase().updateGameMusicVolume(0);
                        } else {
                            handler.getDataBase().updateGameMusicVolume(handler.getDataBase().getGameVolume() + 10);
                        }
                        AudioLoader.setVolume(Assets.menuMusic, handler.getDataBase().getGameVolume());
                        Thread.sleep(100);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if (handler.getMouseManager().getMouseX() >= 742 && handler.getMouseManager().getMouseX() <= 769) {
            if (handler.getMouseManager().getMouseY() >= 279 && handler.getMouseManager().getMouseY() <= 305) {
                if (handler.getMouseManager().isLeftPressed()) {
                    try {
                        if (handler.getDataBase().getGameVolume() == 0) {
                            handler.getDataBase().updateGameMusicVolume(100);
                        } else {
                            handler.getDataBase().updateGameMusicVolume(handler.getDataBase().getGameVolume() - 10);
                        }
                        AudioLoader.setVolume(Assets.level1Music, handler.getDataBase().getGameVolume());
                        AudioLoader.setVolume(Assets.level2Music, handler.getDataBase().getGameVolume());
                        AudioLoader.setVolume(Assets.level3Music, handler.getDataBase().getGameVolume());
                        Thread.sleep(100);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if (handler.getMouseManager().getMouseX() >= 689 && handler.getMouseManager().getMouseX() <= 722) {
            if (handler.getMouseManager().getMouseY() >= 329 && handler.getMouseManager().getMouseY() <= 362) {
                if (handler.getMouseManager().isLeftPressed()) {


                }
            }
        }

        if (handler.getMouseManager().getMouseX() >= 741 && handler.getMouseManager().getMouseX() <= 770) {
            if (handler.getMouseManager().getMouseY() >= 330 && handler.getMouseManager().getMouseY() <= 362) {
                if (handler.getMouseManager().isLeftPressed()) {

                }
            }
        }

    }
        //temporary to go directly to the game state
        /*handler.getMouseManager().setUiManager(null);
        State.setState(handler.getGame().gameState);*/

    @Override
    public void draw(Graphics g) {
        g.drawImage(Assets.settings,0,0,handler.getWidth(), handler.getHeight(), null);
        uiManager.draw(g);
        g.drawImage(Assets.sword,handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(),64,64,null);

        g.setColor(Color.black);
        g.setFont(new Font("Serif", Font.PLAIN, 48));
        try {

            g.drawString(Integer.toString(handler.getDataBase().getMenuVolume()), 590, 255);
            g.drawString(Integer.toString(handler.getDataBase().getGameVolume()), 590, 310);

        } catch (SQLException e) {
            System.err.println("Eroare la incarcare din baza de date in SettingsState->Draw.");
        }

    }
}