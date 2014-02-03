import info.bliki.wiki.*;
import info.bliki.wiki.dump.IArticleFilter;
import info.bliki.wiki.dump.Siteinfo;
import info.bliki.wiki.dump.WikiArticle;

import org.xml.sax.SAXException;
class Other implements IArticleFilter {

                public void process(WikiArticle page, Siteinfo siteinfo) throws SAXException {
                        if (page.isCategory()) {
                                System.out.println(page.getTitle());
                        }
                }

				@Override
				public boolean process(WikiArticle arg0) {
					// TODO Auto-generated method stub
					return false;
				}

        }