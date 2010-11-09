package pdf.stamping

import com.lowagie.text.pdf.PdfReader
import com.lowagie.text.pdf.PdfStamper
import com.lowagie.text.pdf.AcroFields

class PdfStampingService {

    static transactional = true

    def stamp(InputStream inputStream, OutputStream outputStream, name) {

      PdfReader reader = new PdfReader(inputStream)
      PdfStamper stamper = new PdfStamper(reader, outputStream)
      AcroFields acroFields = stamper.getAcroFields()
      acroFields.setField('name' , name)
      stamper.setFormFlattening true
      stamper.close()
    }
}
