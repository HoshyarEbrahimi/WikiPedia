package com.hoshyar.ebrahimi.wikipedia.adapters

import com.hoshyar.ebrahimi.wikipedia.data.ItemPost

interface ItemEvents {
	 fun onItemClicked(itemPost: ItemPost)
}