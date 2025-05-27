package DAOImplement;

import java.util.List;
import models.*;

public interface PabrikImplement {
    public void insert(Pabrik p);
    public void update(Pabrik p);
    public void delete(int id);
    public List<Pabrik> getAll();
}
