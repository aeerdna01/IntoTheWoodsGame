package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class soilPTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip pavaj.
 */
public class SoilPTile extends Tile{

    /*! \fn public SoilPTile(int id)
     \brief Constructorul de initializare al clasei
      \param id Id-ul dalei util in desenarea hartii.
 */
    public SoilPTile(int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.soilP,id);
    }

    /*! \fn public boolean IsSolid()
       \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
   */
    @Override
    public boolean IsSolid() {
        return false;
    }
}
