package org.to2mbn.jmccc.version;

import java.util.Objects;

public class AssetIndexInfo extends DownloadInfo {

	private static final long serialVersionUID = 1L;

	private String id;
	private long totalSize;
	private boolean known;

	/**
	 * Creates an AssetIndexInfo.
	 * 
	 * @param url the url, null if the url is unknown
	 * @param checksum the SHA-1 checksum, null if the checksum is unknown
	 * @param size the file size, -1 if the size is unknown
	 * @param id the version of the asset index
	 * @param totalSize the total size of the assets, -1 if the total size if unknown
	 * @param known true if the checksum and size are known
	 * @throws NullPointerException if <code>id==null</code>
	 */
	public AssetIndexInfo(String url, String checksum, long size, String id, long totalSize, boolean known) {
		super(url, checksum, size);
		Objects.requireNonNull(id);
		this.id = id;
		this.totalSize = totalSize;
		this.known = known;
	}

	/**
	 * Gets the version of the asset index.
	 * 
	 * @return the version of the asset index.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the total size of the assets, -1 if the total size if unknown. (the 'totalSize' element in the json)
	 * 
	 * @return the total size of the assets, -1 if the total size if unknown
	 */
	public long getTotalSize() {
		return totalSize;
	}

	/**
	 * Gets whether the checksum and size are known.
	 * 
	 * @return true if the checksum and size are known
	 */
	public boolean isKnown() {
		return known;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), id, totalSize, known);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof AssetIndexInfo && super.equals(obj)) {
			AssetIndexInfo another = (AssetIndexInfo) obj;
			return Objects.equals(id, another.id) && totalSize == another.totalSize && known == another.known;
		}
		return false;
	}

}
