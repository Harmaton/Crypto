package com.njagi.crypto.domain.model

import com.njagi.crypto.data.remote.dto.Links
import com.njagi.crypto.data.remote.dto.LinksExtended
import com.njagi.crypto.data.remote.dto.Tag
import com.njagi.crypto.data.remote.dto.Team
import com.njagi.crypto.data.remote.dto.Whitepaper

data class CoinDetail (
    val description: String,
    val developmentStatus: String,
    val firstDataAt: String,
    val hardwareWallet: Boolean,
    val hashAlgorithm: String,
    val id: String,
    val isActive: Boolean,
    val isNew: Boolean,
    val lastDataAt: String,
    val links: Links,
    val linksExtended: List<LinksExtended>,
    val logo: String,
    val message: String,
    val name: String,
    val openSource: Boolean,
    val orgStructure: String,
    val proofType: String,
    val rank: Int,
    val startedAt: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<Team>,
    val type: String,
    val whitepaper: Whitepaper
)