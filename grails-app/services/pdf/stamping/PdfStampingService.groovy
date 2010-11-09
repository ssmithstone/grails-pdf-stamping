package pdf.stamping

import com.lowagie.text.pdf.PdfReader
import com.lowagie.text.pdf.PdfStamper
import com.lowagie.text.pdf.AcroFields

class PdfStampingService {

    static transactional = true

    def stamp(InputStream inputStream, OutputStream outputStream) {

      PdfReader reader = new PdfReader(inputStream)
      PdfStamper stamper = new PdfStamper(reader, outputStream)
      AcroFields acroFields = stamper.getAcroFields()
      acroFields.setField('name' , 'Stephen Smithstone')
    }
}
